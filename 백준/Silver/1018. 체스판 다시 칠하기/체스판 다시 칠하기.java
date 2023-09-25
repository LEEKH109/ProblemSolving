import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		char [][] arr = new char [N][M];
		for(int  i = 0; i < N; i++) {
			arr[i] = sc.next().toCharArray();
		}
		// 방법1 규칙에 맞는 흰색 시작 보드와 검은색 시작 보드를 각각 배열로 만들어서
		// 		배열 전체순회하면서 바교? => 이건 배열 전체를 총 4번 순회하므로 별로 인 것 같다.
		//		2초라서 돌아가기는 할 탠데
		char [][] tmp_black =  new char [8][8];
		char [][] tmp_white = new char [8][8];
		for(int x = 0; x < 8; x++) {
			for(int y = 0; y < 8; y++) {
				if(y%2 == 0 && x%2 == 0) {
					tmp_black[x][y] = 'B';
					tmp_white[x][y] = 'W';
				}else if(y%2 == 0 && x%2 == 1) {
					tmp_black[x][y] = 'W';
					tmp_white[x][y] = 'B';
				}else if(y%2 == 1 && x%2 == 0) {
					tmp_black[x][y] = 'W';
					tmp_white[x][y] = 'B';
				}else {
					tmp_black[x][y] = 'B';
					tmp_white[x][y] = 'W';
				}
			}
		}
		int cnt = Integer.MAX_VALUE;
		for(int dx = 0; dx <= N-8; dx++) {
			for(int dy = 0; dy <= M-8; dy++) {
				int cnt_black = 0;
				int cnt_white = 0;
				for(int x = 0; x < 8; x++) {
					for(int y = 0; y < 8; y++) {
						if(tmp_black[x][y] != arr[x+dx][y+dy]) {
							cnt_black++;
						}
						if(tmp_white[x][y] != arr[x+dx][y+dy]) {
							cnt_white++;
						}	
					}
				}
				cnt = Math.min(cnt, cnt_black);
				cnt = Math.min(cnt, cnt_white);
			}
		}
		System.out.println(cnt);
		sc.close();
	}
}