import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    class Page {
        String url;
        int baseScore;
        int linkCount;
        double linkScore;
        double matchingScore;
        List<String> outboundLinks;

        Page(String url) {
            this.url = url;
            this.baseScore = 0;
            this.linkCount = 0;
            this.linkScore = 0.0;
            this.matchingScore = 0.0;
            this.outboundLinks = new ArrayList<>();
        }
    }

    public int solution(String word, String[] pages) {
        Map<String, Page> pageMap = new HashMap<>();
        Pattern urlPattern = Pattern.compile("<meta property=\"og:url\" content=\"(.*?)\"/>");
        Pattern linkPattern = Pattern.compile("<a href=\"(.*?)\">");

        word = word.toLowerCase();  // 대소문자 구분 없이 검색하기 위해

        // 각 페이지에 대해 URL과 기본 점수, 외부 링크를 추출
        for (int i = 0; i < pages.length; i++) {
            String html = pages[i];

            // URL 추출
            Matcher urlMatcher = urlPattern.matcher(html);
            if (!urlMatcher.find()) continue;
            String url = urlMatcher.group(1);

            Page page = new Page(url);

            // 기본 점수 계산
            page.baseScore = countWordInBody(html, word);

            // 외부 링크 추출
            Matcher linkMatcher = linkPattern.matcher(html);
            while (linkMatcher.find()) {
                String outboundLink = linkMatcher.group(1);
                page.outboundLinks.add(outboundLink);
            }
            page.linkCount = page.outboundLinks.size();

            pageMap.put(url, page);
        }

        // 링크 점수 계산
        for (Page page : pageMap.values()) {
            double linkValue = (page.linkCount == 0) ? 0 : (double) page.baseScore / page.linkCount;
            for (String outboundLink : page.outboundLinks) {
                if (pageMap.containsKey(outboundLink)) {
                    pageMap.get(outboundLink).linkScore += linkValue;
                }
            }
        }

        // 매칭 점수 계산 및 가장 높은 점수를 가진 페이지의 인덱스 찾기
        double maxMatchingScore = -1;
        int answer = 0;
        for (int i = 0; i < pages.length; i++) {
            String html = pages[i];

            Matcher urlMatcher = urlPattern.matcher(html);
            if (!urlMatcher.find()) continue;
            String url = urlMatcher.group(1);

            Page page = pageMap.get(url);
            page.matchingScore = page.baseScore + page.linkScore;

            if (page.matchingScore > maxMatchingScore) {
                maxMatchingScore = page.matchingScore;
                answer = i;
            }
        }

        return answer;
    }

    private int countWordInBody(String html, String word) {
        String bodyContent = extractBodyContent(html);
        String[] words = bodyContent.toLowerCase().split("[^a-zA-Z]+");  // 알파벳이 아닌 문자를 기준으로 분리
        int count = 0;
        for (String w : words) {
            if (w.equals(word)) {
                count++;
            }
        }
        return count;
    }

    private String extractBodyContent(String html) {
        Pattern pattern = Pattern.compile("<body>(.*?)</body>", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(html);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return "";
    }
}