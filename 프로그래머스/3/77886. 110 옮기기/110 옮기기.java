// 1 ≤ s의 길이 ≤ 1,000,000
// 1 ≤ s의 각 원소 길이 ≤ 1,000,000
// 1 ≤ s의 모든 원소의 길이의 합 ≤ 1,000,000
// 음 110이 어디 있는지 찾는게 1번
// 110이 여러개 일 대도 커버가 되는게 2번   
// 110을 체크하고 전부 제거, 그리고 갯수 카운트
// 문제 예시에서 주어진 예제들을 보면 문자열에 0 이 있을 때는 가장 마지막 0 뒤에 110을 달아주면 되고
// 0이 없으면 시작 부분에 110 달아주면 된다.
// 3600ms 나오는데 다른 사람들은?

import java.util.*;

class Solution {
    public String[] solution(String[] s) {
        int n = s.length;
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            int m = s[i].length();
            List<Character> a = new ArrayList<>();
            int c = 0;
            for (int j = 0; j < m; j++) {
                a.add(s[i].charAt(j));
                int l = a.size();
                while (l > 2 && a.get(l - 3) == '1' && a.get(l - 2) == '1' && a.get(l - 1) == '0') {
                    c++;
                    a.remove(l - 1);
                    a.remove(l - 2);
                    a.remove(l - 3);
                    l -= 3;
                }
            }
            if (c > 0) {
                char [] x = new char[m];
                int o = 0;
                int r = a.size();
                while (r > 0 && a.get(r - 1) == '1') {
                    r--;
                }
                for (int j = 0; j < r; j++) {
                    x[o++] = a.get(j);
                }
                for (int j = 0; j < c; j++) {
                    x[o++] = '1';
                    x[o++] = '1';
                    x[o++] = '0';
                }
                while (r < a.size()) {
                    x[o++] = a.get(r++);
                }
                answer[i] = new String(x);
            } else {
                answer[i] = s[i];
            }
        }
        return answer;
    }
}

