import java.util.Scanner;

public class Main {
	final static int Red = 0;
	final static int Green = 1;
	final static int Blue = 2;

	static int[][] Cost;
	static int[][] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Cost = new int[N][3];
		dp = new int[N][3];
		for (int i = 0; i < N; i++) {
			Cost[i][Red] = sc.nextInt();
			Cost[i][Green] = sc.nextInt();
			Cost[i][Blue] = sc.nextInt();
		}
		//초기값 설정
		dp[0][Red] = Cost[0][Red];
		dp[0][Green] = Cost[0][Green];
		dp[0][Blue] = Cost[0][Blue];
		System.out.print(Math.min(Paint_cost(N - 1, Red), Math.min(Paint_cost(N - 1, Green), Paint_cost(N - 1, Blue))));
	}

	static int Paint_cost(int N, int color) {
		if (dp[N][color] == 0) {
			switch (color) {
			case Red:
				dp[N][Red] = Math.min(Paint_cost(N - 1, Green), Paint_cost(N - 1, Blue)) + Cost[N][Red];
				break;
			case Green:
				dp[N][Green] = Math.min(Paint_cost(N - 1, Red), Paint_cost(N - 1, Blue)) + Cost[N][Green];
				break;
			case Blue:
				dp[N][Blue] = Math.min(Paint_cost(N - 1, Red), Paint_cost(N - 1, Green)) + Cost[N][Blue];
				break;
			}
		}
		return dp[N][color];
	}
}