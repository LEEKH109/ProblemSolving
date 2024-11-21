class Solution {
    int MOD = 20170805;

    public int solution(int m, int n, int[][] cityMap) {
        int[][][] dp = new int[m][n][2];

        // 첫 행 초기화
        for (int j = 0; j < n; j++) {
            if (cityMap[0][j] == 1) { // 통행 금지
                break;
            }
            dp[0][j][0] = 1; // 왼쪽에서 오는 경로
            dp[0][j][1] = 0; // 위에서 오는 경로는 없음
        }

        // 첫 열 초기화
        for (int i = 0; i < m; i++) {
            if (cityMap[i][0] == 1) { // 통행 금지
                break;
            }
            dp[i][0][1] = 1; // 위에서 오는 경로
            dp[i][0][0] = 0; // 왼쪽에서 오는 경로는 없음
        }

        // DP 계산
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (cityMap[i][j] == 1) {
                    dp[i][j][0] = 0; // 통행 금지
                    dp[i][j][1] = 0;
                } else {
                    // 왼쪽에서 오는 경로 계산
                    dp[i][j][0] = dp[i][j - 1][0];
                    if (cityMap[i][j - 1] == 0) { // 회전 가능
                        dp[i][j][0] = (dp[i][j][0] + dp[i][j - 1][1]) % MOD;
                    }

                    // 위에서 오는 경로 계산
                    dp[i][j][1] = dp[i - 1][j][1];
                    if (cityMap[i - 1][j] == 0) { // 회전 가능
                        dp[i][j][1] = (dp[i][j][1] + dp[i - 1][j][0]) % MOD;
                    }
                }
            }
        }

        // 결과 반환: 도착점에서의 왼쪽과 위에서 오는 경로의 합
        int answer = (dp[m - 1][n - 1][0] + dp[m - 1][n - 1][1]) % MOD;
        return answer;
    }
}