import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		if (N == 1) {
			System.out.println(0);
		} else if (N <= 3) {
			System.out.println(1);
		} else {
			int[] dp = new int[N + 1];
			dp[3] = 1;
			dp[2] = 1;
			// dp[1] = 0;
			for (int i = 4; i <= N; i++) {
				int tmp = Integer.MAX_VALUE;
				if (i % 3 == 0) {
					tmp = Math.min(tmp, dp[i / 3] + 1);
				}
				if (i % 2 == 0) {
					tmp = Math.min(tmp, dp[i / 2] + 1);
				}
				tmp = Math.min(tmp, dp[i - 1] + 1);
				dp[i] = tmp;
//				dp[1] = 0;
//				dp[2] = 1;
//				dp[3] = 1;
//				dp[4] = dp[3] + 1 = 1+1 =2;
//				dp[5] = dp[4]+1=3;
//				dp[6] = dp[2]+1=2;
//				dp[7] = dp[6]+1 =3;
//				dp[8] = dp[4]+1 = 3;
//				dp[9] = dp[3]+1 = 2;
//				dp[10] = dp[9]+1 = 3;
			}
			System.out.println(dp[N]);
		}
		sc.close();
	}
}