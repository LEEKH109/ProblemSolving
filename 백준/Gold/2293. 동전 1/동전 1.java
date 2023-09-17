import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 동전들의 갯수
		int K = sc.nextInt(); // 동전들을 조합해서 만들어야 하는 목표 합 가격
		int[] coin = new int[N];
        for (int n = 0; n < N; n++) {
            coin[n] = sc.nextInt();
        }
        int[] dp = new int[K + 1];
        dp[0] = 1; // 0원을 만드는 경우의 수는 1가지입니다.
        // 여기까지 초기 세팅 끝
     	// 어차피 DP[0]은 0이므로 그냥 패스 => 여기가 문제 dp[0] = 1이다.
        for (int el : coin) {
            for (int i = el; i <= K; i++) {
                dp[i] += dp[i - el];
            }
        }
        System.out.println(dp[K]);
        sc.close();
    }
}