import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
	static int N;
	static char[][] map;
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new char[N][N * 2 - 1];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N * 2 - 1; j++) {
				map[i][j] = ' ';// 모든 char 배열을 공백으로 초기화
			}
		}
		dfs(0, N - 1, N);// dfs 돌리기
		// 여기서부터 출력 단
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N * 2 - 1; j++) {
				bw.write(String.valueOf(map[i][j]));
			}
			bw.write("\n");
		}
		bw.close();
		sc.close();
	}

	static void dfs(int x, int y, int n) {
		if (n == 3) {//정지조건 => 입력 n은 무조건 3*2^n 이므로 정지값은 3*2^0 = 3
			map[x][y] = map[x + 1][y - 1] = map[x + 1][y + 1] = map[x + 2][y
					- 2] = map[x + 2][y - 1] = map[x + 2][y - 0] = map[x + 2][y + 1] = map[x + 2][y + 2] = '*';
			return;
			// 이게 무슨 의미냐면 해당 좌표만 공백에서 별로 바꾼다는 뜻
		}
		dfs(x, y, n / 2);
		dfs(x + n / 2, y - n / 2, n / 2);
		dfs(x + n / 2, y + n / 2, n / 2);
	}
}