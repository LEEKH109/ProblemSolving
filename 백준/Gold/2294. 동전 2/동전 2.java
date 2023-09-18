import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 동전의 종류 갯수 입력
		int K = sc.nextInt(); // 타겟 비용
		int[] coin = new int[N];
		for (int i = 0; i < N; i++) {
			coin[i] = sc.nextInt();
		} // 입력 처리 끝
		int[] dp = new int[K + 1];
		Arrays.fill(dp, 100_000);// 최소값을 비교할거라 초기값이 0이면 안된다.
		dp[0] = 0;// 0번 인덱스만 밑의 로직을 위해 0으로 선언해준다.
		// 동전1과 동일하게 목표원까지 배열을 만들어 준다.
		for (int k = 1; k <= K; k++) {
			for (int el : coin) {// 모든 동전들 다 테스트
				if(k>= el){
					dp[k] = Math.min(dp[k], dp[k-el]+1);
					//대신 이러러면 dp는 전부 int 최대값으로 넣어주기
				}
			}
		}
		System.out.println(dp[K] >= 100_000 ? "-1" : dp[K]);
		sc.close();
	}
}