import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt(); // 테스트 케이스 입력
		for (int T = 0; T < tc; T++) {
			int N = sc.nextInt(); // 행의 개수
			int M = sc.nextInt(); // 열의 개수
			int[] Wcnt = new int[N]; // 각 행에서의 색상 개수
			int[] Bcnt = new int[N];
			int[] Rcnt = new int[N];
			// 각 행의 W, B, R 개수 저장
			for (int i = 0; i < N; i++) {
				String flagRow = sc.next();
				for (int j = 0; j < M; j++) {
					char word = flagRow.charAt(j);
					if (word == 'W')
						Wcnt[i]++;
					else if (word == 'B')
						Bcnt[i]++;
					else
						Rcnt[i]++;
				}
			}
			// 모든 경우의 수를 확인하여 최솟값 구하기
			// 첫 줄은 무조건 하얀색 마지막 줄은 무조건 빨간색이라는 것에 주의
			int sum = 0;
			for (int i = 1; i <= N - 2; i++) {
				// W가 나올 수 있는 경우의 수 : 1 ~ N-2
				for (int j = i; j < N - 1; j++) {
					// B가 나올 수 있는 경우 : i ~ N-1
					int wCnt = 0;
					int bCnt = 0;
					int rCnt = 0;
					for (int k = 0; k < i; k++)
						wCnt += Wcnt[k]; // W의 개수
					for (int k = i; k <= j; k++)
						bCnt += Bcnt[k]; // B의 개수
					for (int k = j + 1; k < N; k++)
						rCnt += Rcnt[k]; // R의 개수
					sum = Math.max(sum, wCnt + bCnt + rCnt); // sum이 높을수록 새로 칠해야하는 칸의 개수가 작음
				}
			}
			sum = N * M - sum;
			System.out.println("#" + (T + 1) + " " + sum);
		}
		sc.close();
	}
}