// 집 도둑 문제
import java.util.*;
class Solution {
    public int solution(int[] money) {
        if (money.length == 1) return money[0];
        
        return Math.max(rob(Arrays.copyOfRange(money, 0, money.length - 1)),
                        rob(Arrays.copyOfRange(money, 1, money.length)));
    }

    private int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        nums[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            nums[i] = Math.max(nums[i - 1], nums[i - 2] + nums[i]);
        }

        return nums[nums.length - 1];
    }
}