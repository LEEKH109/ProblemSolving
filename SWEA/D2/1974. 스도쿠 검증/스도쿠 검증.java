import java.util.Arrays;
import java.util.Scanner;
//누적합 버전
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int N = 9;
		for (int tc = 1; tc <= T; tc++) {
			int sdokucheck = 1;
			int [][] sdoku = new int [N][N];
			for(int x = 0; x < N; x++) {
				for(int y = 0; y < N; y++) {
					sdoku[x][y] = sc.nextInt();
					if(x > 0) {
						sdoku[x][y]+=sdoku[x-1][y];
					}
					
				}
			}//스도큐 배열 세로 누적합 입력 완료
//			for(int i = 0; i < N ; i ++) {
//				System.out.println(Arrays.toString(sdoku[i]));
//			}// 세로 누적합 출력
			if(sdokucheck == 1) {
				for(int i = 0; i < N; i++) {
					if(sdoku[N-1][i]%45 != 0) {
						sdokucheck = 0;
						break;
					}
				}
			}// 누적합이 45 아니면 스도쿠 아님
			for(int x = 0; x < N; x++) {
				for(int y = 1; y < N; y++) {
						sdoku[x][y]+=sdoku[x][y-1];
				}
			}//스도큐 배열 가로 누적합 입력 완료
//			for(int i = 0; i < N ; i ++) {
//				System.out.println(Arrays.toString(sdoku[i]));
//			}// 가로 누적합 출력
			if(sdokucheck == 1) {
				for(int i = 0; i < N; i++) {
					if(sdoku[i][N-1]%45 != 0) {
						sdokucheck = 0;
						break;
					}
				}
			}//45로 안 나눠 떨어지면 스도쿠 아님
			//이제 9칸씩 의 스도쿠를 판별 해야 합니다. 총 9번입니다.
			fail : for(int x = 2; x < N; x+=3) {
				for(int y = 2; y < N; y+=3) {
					if(sdoku[x][y]%45 != 0) {
						sdokucheck = 0;
						break fail;
					}
				}
			}//스도큐 배열 가로 누적합 입력 완료
			System.out.println("#" + tc + " " + sdokucheck);
		}
		sc.close();
	}
}