// 문제: 42893번 (매칭 점수)
// 등급: Level 3
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42893
// [풀이] 
// 노드 선언해서 하는 구현
// 기본 점수 => 
// 코드 속도 가독성 높이려면 정규표현식 둘둘 해야 되는 문제
// 결국 기본 점수와 외부 링크수만 함수화해서 구분해서 돌리면 깔끔
// regex사용법 참고 링크 https://yunamom.tistory.com/224

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    public int solution(String word, String[] pages) {
        Map<String, Page> pageMap = new HashMap<>();
        Pattern urlPattern = Pattern.compile("<meta property=\"og:url\" content=\"(.*?)\"/>");
        Pattern linkPattern = Pattern.compile("<a href=\"(.*?)\">");

        word = word.toLowerCase(); // 입력 단어에 대문자가 포함되는 경우가 있어서 소문자로 변환

        // 페이지 정보를 파싱하여 페이지 객체 생성 및 저장
        for (int i = 0; i < pages.length; i++) {
            // URL 추출
            Matcher urlMatcher = urlPattern.matcher(pages[i]);
                if (urlMatcher.find()) {
                String url = urlMatcher.group(1);
                Page page = new Page(url);
                // 기본 점수 계산
                page.baseScore = countWord(pages[i], word);
                // 외부 링크 추출
                Matcher linkMatcher = linkPattern.matcher(pages[i]);
                while (linkMatcher.find()) {
                    String outLink = linkMatcher.group(1);
                    page.outLink.add(outLink);
                }
                page.linkCount = page.outLink.size(); // 외부 링크 수 계산
                pageMap.put(url, page); // 페이지 정보를 Map에 저장
            }
        }

        // 링크 점수 계산
        for (Page page : pageMap.values()) {
            double linkScore = (page.linkCount == 0) ? 0 : (double) page.baseScore / page.linkCount;

            // 매칭 점수 계산을 위한 링크 점수 갱신
            for (String outLink : page.outLink) {
                if (pageMap.containsKey(outLink)) {
                    pageMap.get(outLink).linkScore += linkScore;
                }
            }
        }

        // 매칭 점수 계산 및 가장 높은 점수를 가진 페이지의 인덱스 찾기
        double maxMatchingScore = -1;
        int answer = 0;
        for (int i = 0; i < pages.length; i++) {
            Matcher urlMatcher = urlPattern.matcher(pages[i]);
            if (urlMatcher.find()) { // URL 매칭이 성공했을 때만 진행
                String url = urlMatcher.group(1);
                Page page = pageMap.get(url);
                // 매칭 점수 = 기본 점수 + 링크 점수
                page.matchingScore = page.baseScore + page.linkScore;
                if (page.matchingScore > maxMatchingScore) {
                    maxMatchingScore = page.matchingScore;
                    answer = i;
                }
            }
        }
        return answer;
    }

    private int countWord(String html, String word) {
        Matcher matcher = Pattern.compile("<body>(.*?)</body>", Pattern.DOTALL).matcher(html);
        if (!matcher.find()) return 0; // <body> 태그가 없으면 0 반환

        String bodyContent = matcher.group(1).toLowerCase(); // 전부 소문자로 통일
        String[] words = bodyContent.split("[^a-zA-Z]+"); // 단어만 남기기
        int count = 0;
        for (String w : words) {
            if (w.equals(word)) {
                count++;
            }
        }
        return count;
    }

    class Page {
        String url;
        int baseScore; // 기본 점수
        int linkCount; // 외부 링크 수
        double linkScore; // 링크 점수 = 기본 점수 / 외부 링크 수
        double matchingScore; // 매칭 점수 = 기본 점수 + 링크 점수
        List<String> outLink; // 연결된 링크 리스트로 관리

        Page(String url) {
            this.url = url;
            this.baseScore = 0;
            this.linkCount = 0;
            this.linkScore = 0.0;
            this.matchingScore = 0.0;
            this.outLink = new ArrayList<>();
        }
    }
}