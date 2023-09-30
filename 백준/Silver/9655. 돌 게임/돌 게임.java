import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int dp[] = new int[1_001];
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= N; i++) {
			dp[i] = Math.min(dp[i - 3] + 1, dp[i - 1] + 1);
		}
		System.out.println(dp[N] % 2 == 1 ? "SK" : "CY");
		sc.close();
	}
}