import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int [] dp = new int [N+1];
		//1*2 or 2*1 직사각형 막대 블록를 사용하는 문제
		dp[0] = 1; // =>얘는 왜 1인가? dp[2]를 위한 가짜 값이라고 생각해주면 편하다.
		//이 문제의 점화식은 dp[i] = dp[i-1]*1+dp[i-2]*1 이다.
		dp[1] = 1;
		for(int i = 2; i <= N; i++) {
			dp[i] = (dp[i-1]+dp[i-2])%10_007;
		}	
		System.out.println(dp[N]);
		sc.close();
	}
}