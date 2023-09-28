import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int dp[] = new int[N + 1];
		// 1×2, 2×1과 2×2 타일 사용
		// 점화식 구하기
		dp[0] = 1;
		dp[1] = 1;
		// 여기가지 사전에 입력하는 값
		// 점화식 구하는 과정
		// dp[2] = dp[1]*1+dp[0]*2;
		for (int i = 2; i <= N; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10_007;
		}
		System.out.println(dp[N]);
		sc.close();
	}
}