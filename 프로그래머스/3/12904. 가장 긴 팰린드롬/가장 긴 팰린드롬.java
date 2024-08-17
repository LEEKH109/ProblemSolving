class Solution {
    public int solution(String s) {
        int n = s.length();
        if (n == 1) return 1;
        int answer = 1; // 최소 팰린드롬 길이는 1
        char[] input = s.toCharArray();

        for (int i = 0; i < n; i++) {
            // 홀수 길이 팰린드롬
            answer = Math.max(answer, findPalindromeLength(input, i, i));
            // 짝수 길이 팰린드롬
            if (i < n - 1 && input[i] == input[i + 1]) {
                answer = Math.max(answer, findPalindromeLength(input, i, i + 1));
            }
        }
        return answer;
    }

    // 중심점을 기준으로 팰린드롬의 길이를 찾는 메서드
    private int findPalindromeLength(char[] input, int left, int right) {
    while (left >= 0 && right < input.length && input[left] == input[right]) {
        left--;
        right++;
    }
    return right - left - 1; // 정확한 팰린드롬 길이 계산
}
}
// class Solution {
//     public int solution(String s) {
//         int n = s.length();
//         if (n == 1) return 1;
//         int answer = 1; // 최소 길이 팰린드롬은 1
//         char[] input = s.toCharArray();

//         for (int i = 0; i < n; i++) {
//             // 짝수 길이 팰린드롬 체크
//             if (i < n - 1 && input[i] == input[i + 1]) {
//                 int length = 0;
//                 boolean flag = false;
//                 while (!flag) {
//                     if (i - length >= 0 && i + 1 + length < n && input[i - length] == input[i + 1 + length]) {
//                         length++;
//                     } else {
//                         flag = true;
//                         length--; // 조건을 벗어났을 때 추가로 길이가 늘어난 부분을 제거
//                     }
//                 }
//                 answer = Math.max(answer, length * 2 + 2);
//             }

//             // 홀수 길이 팰린드롬 체크
//             int length = 0;
//             boolean flag = false;
//             while (!flag) {
//                 if (i - length >= 0 && i + length < n && input[i - length] == input[i + length]) {
//                     length++;
//                 } else {
//                     flag = true;
//                     length--; // 조건을 벗어났을 때 추가로 길이가 늘어난 부분을 제거
//                 }
//             }
//             answer = Math.max(answer, length * 2 + 1);
//         }
//         return answer;
//     }
// }