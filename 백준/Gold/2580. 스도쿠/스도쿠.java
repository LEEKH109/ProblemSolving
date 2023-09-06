import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N = 9;
	static int [][] board = new int [N][N];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int x = 0; x < N; x++) {
			for(int y = 0; y < N; y++) {
				board[x][y] = sc.nextInt();
			}
		}//sdoku 입력 완료
		dfs(0,0);
		sc.close();
	}
	public static void dfs(int x, int y) {
		//스도쿠 탐색 dfs
		if(y == 9) {//한 줄 돌았으니
			dfs(x+1,0);
			return;
		}
		if(x == 9) {
			//여기까지 왔으면 배열은 전부 돈 것 이므로
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					System.out.print(board[i][j]+" ");
				}
				System.out.println("");
			}
			System.exit(0);
			return;
		}
		// 스도쿠배열에서 빈칸인 0을 만났을 때,
		if(board[x][y] == 0) {
		    for(int i=1; i<= N; i++) {
		        if(sdoku(x, y, i)) {
		            board[x][y] = i;
		            dfs(x, y + 1);
		            board[x][y] = 0; // 백트래킹
		        }
		    }
		    return; // 다음 숫자로 넘어가지 않도록 return 추가
		}
		dfs(x,y+1);
	}
	
	public static boolean sdoku(int x, int y, int test_value) {
		// 해당 좌표에 해당 값을 대입 했을 때 해당 점 기준에서 
		// 스도쿠인지 아닌지를 반환하는 함수
		for(int i = 0; i < N; i++) {
			if(board[x][i] == test_value || board[i][y] == test_value ) {
				// 두 조건 중 하나라도 true이면 스도쿠 조건 위배 이므로 false 반환
				return false;
			}
		}
		int xd = x/3; // 5 => 1 => 3~6
		int yd = y/3; // 2 => 0 => 1~3
		for(int dx = xd*3; dx < xd*3+3; dx++) {
			for(int dy = yd*3; dy < yd*3+3; dy++) {
				if(board[dx][dy] == test_value) {
					return false;
				}
			}
		}// 이 두 조건을 다 통과 했다면 해당 점 기준으로 스도쿠 통과
		return true;
	}
}