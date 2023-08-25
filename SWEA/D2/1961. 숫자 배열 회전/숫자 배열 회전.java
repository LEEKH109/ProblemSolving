import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] tmp = new int[N][N];// 입력을 담을 이차원 배열 설정
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < N; y++) {
					tmp[x][y] = sc.nextInt();
				}
			}
			int[][] tmpR = new int[N][N];
			int[][] tmpC = new int[N][N];
			int[][] tmpL = new int[N][N];
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < N; y++) {
					tmpR[x][y] = tmp[N-1-y][x];
					tmpC[N-1-x][N-1-y] = tmp[x][y];
					tmpL[x][y] = tmp[y][N-1-x];
				}
			}
			// 각 회전 배열들을 세로 방향으로 출력
			System.out.println("#"+tc);
	        for (int i = 0; i < N; i++) {
	            for (int j = 0; j < N; j++) {
	                System.out.print(tmpR[i][j]);
	            }
	            System.out.print(" ");

	            for (int j = 0; j < N; j++) {
	                System.out.print(tmpC[i][j]);
	            }
	            System.out.print(" ");

	            for (int j = 0; j < N; j++) {
	                System.out.print(tmpL[i][j]);
	            }

	            System.out.println();
	        }
		}
		sc.close();
	}
}