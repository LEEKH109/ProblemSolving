import java.util.Scanner;
//완전탐색=>주현센세.....아리가또
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int N = 9;
		for(int tc = 1; tc <=T; tc++) {
			int [][] sdoku = new int [N][N];
			for(int y = 0; y < N; y++) {
				for(int x = 0; x < N; x++) {
					sdoku[x][y] = sc.nextInt();
				}
			}//스도큐 배열 입력 완료
		//가로 스도쿠 탐색
		int sdokucheck = 1;
		fail: for(int i = 0; i < N; i++) {
			int sumx = 1;
			int sumy = 1;
			for(int j = 0; j < N; j++) {
				sumx*=sdoku[i][j];
				sumy*=sdoku[j][i];
			}
			if(sumx != 362_880 || sumy != 362_880) {
				sdokucheck = 0;
				break fail;
			}
		}// 가로 세로 탐색 종료
		fail: for(int y = 0; y < N; y+=3) {
			for(int x = 0; x < N; x+=3) {
				int sum = 1;
				for(int i = 0; i < 3; i++) {
					for(int j = 0; j < 3; j++) {
						sum*=sdoku[x+i][y+j];
					}
				}
				if(sum != 362_880) {
					sdokucheck = 0;
					break fail;
				}
			}
		}//스도큐 배열 입력 완료
		System.out.println("#"+tc+" "+sdokucheck);	
		}
		sc.close();
	}
}