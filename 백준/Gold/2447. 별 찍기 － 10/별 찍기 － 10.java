import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
	static char[][] arr;
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		arr = new char[N][N];
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				arr[x][y] = ' ';
			}
		} // 배열 공백 초기화
		dfs((N - 1) / 2, (N - 1) / 2, N);
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				bw.write(String.valueOf(arr[x][y]));
			}
			bw.write("\n");
		}
		bw.close();
		sc.close();
	}

	static void dfs(int x, int y, int n) {
		if (n == 3) {
			arr[x + 1][y + 1] = arr[x][y + 1] = arr[x - 1][y
					+ 1] = arr[x + 1][y] = arr[x - 1][y] = arr[x + 1][y - 1] = arr[x][y - 1] = arr[x - 1][y - 1] = '*';
			return;
		}
		int N = n / 3;
		dfs(x - N, y - N, N);
		dfs(x - N, y, N);
		dfs(x - N, y + N, N);
		dfs(x, y - N, N);
		dfs(x, y + N, N);
		dfs(x + N, y - N, N);
		dfs(x + N, y, N);
		dfs(x + N, y + N, N);
	}
}
