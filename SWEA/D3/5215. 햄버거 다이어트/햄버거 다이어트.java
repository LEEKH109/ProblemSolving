import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();// 테스트케이스 수 입력
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int L = sc.nextInt();
			int maxTaste = 0;
			int[][] food = new int[N][2];
			for (int i = 0; i < N; i++) {
				food[i][0] = sc.nextInt();
				food[i][1] = sc.nextInt();
			}
			for (int i = 1; i < (1 << N); i++) { // 2^N 만큼 경우의 수 쨰기
				int sumTaste = 0;
				int cal = 0;
				for (int j = 0; j < N; j++) {
					if ((i & (1 << j)) > 0) {
						sumTaste+=food[j][0];
						cal+=food[j][1];
					}
				}
				if(cal<= L) {
					maxTaste = Math.max(maxTaste, sumTaste);
				}

			}
			System.out.println("#"+tc+" "+maxTaste);
		}
		sc.close();
	}
}