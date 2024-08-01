import java.util.*;
class Solution {
    public int solution(int[] nums) {
        
        int n = nums.length;
        if(n == 0) return 0;// 예외 처리1
        if(n == 1) return nums[0];// 예외 처리2
        int result2 = max(nums, 0, n - 2);// 첫 번째 집부터 마지막 집 바로 전까지
        int result1 = max(nums, 1, n - 1);// 두 번째 집부터 마지막 집 까지

        return Math.max(result1, result2);// 두 경우 중 최대값
    }

    private int max(int[] nums, int l, int r) {
        int prev1 = 0;
        int prev2 = 0;
        for(int i = l; i <= r; i++) {
            int tmp = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = tmp;
        }

        return prev1;
    }
}