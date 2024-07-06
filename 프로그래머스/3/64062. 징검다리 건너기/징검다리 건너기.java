class Solution {
    public int solution(int[] stones, int k) {
        int left = 1; // 최소 1명은 건널 수 있음
        int right = 200000000; // stones의 원소 최대값
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (canCross(stones, k, mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    private boolean canCross(int[] stones, int k, int num) {
        int count = 0; // 연속으로 0이 되는 디딤돌의 개수를 세는 변수

        for (int stone : stones) {
            if (stone - num < 0) {
                count++;
            } else {
                count = 0;
            }
            if (count == k) return false;
        }

        return true;
    }
}