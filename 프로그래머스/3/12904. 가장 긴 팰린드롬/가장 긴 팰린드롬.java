class Solution {
    public int solution(String s) {
        int n = s.length();
        if (n == 1) return 1;
        int answer = 1; // 최소 길이 팰린드롬은 1
        char[] input = s.toCharArray();

        for (int i = 0; i < n; i++) {
            // 짝수 길이 팰린드롬 체크
            if (i < n - 1 && input[i] == input[i + 1]) {
                int length = 0;
                boolean flag = false;
                while (!flag) {
                    if (i - length >= 0 && i + 1 + length < n && input[i - length] == input[i + 1 + length]) {
                        length++;
                    } else {
                        flag = true;
                        length--; // 조건을 벗어났을 때 추가로 길이가 늘어난 부분을 제거
                    }
                }
                answer = Math.max(answer, length * 2 + 2);
            }

            // 홀수 길이 팰린드롬 체크
            int length = 0;
            boolean flag = false;
            while (!flag) {
                if (i - length >= 0 && i + length < n && input[i - length] == input[i + length]) {
                    length++;
                } else {
                    flag = true;
                    length--; // 조건을 벗어났을 때 추가로 길이가 늘어난 부분을 제거
                }
            }
            answer = Math.max(answer, length * 2 + 1);
        }
        return answer;
    }
}