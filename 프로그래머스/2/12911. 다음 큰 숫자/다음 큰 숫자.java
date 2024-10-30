class Solution {
    public int solution(int n) {
        int targetCount = Integer.bitCount(n); // n의 1의 개수를 구함
        int answer = n + 1; // n보다 큰 수부터 탐색 시작

        // n보다 큰 숫자 중에서 1의 개수가 같은 숫자를 찾음
        while (Integer.bitCount(answer) != targetCount) {
            answer++;
        }

        return answer;
    }
}