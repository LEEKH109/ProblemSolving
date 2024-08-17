class Solution {
    public int solution(int n, int[] tops) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = tops[0] == 1 ? 4 : 3;

        for (int i = 1; i < n; i++) {
            dp[i+1] = ((tops[i] == 1 ? 4 : 3) * dp[i] - dp[i-1]) % 10007;
            if (dp[i+1] < 0) dp[i+1] += 10007;
        }
        return dp[n];
    }
}