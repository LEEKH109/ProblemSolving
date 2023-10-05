import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int map[][];
	static int[][] temp;
	static boolean visited[][];
	static int N, M, result;
	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		result = 0;
		map = new int[N][M];
		temp = new int[N][M];
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < M; y++) {
				map[x][y] = sc.nextInt();
			}
		}
		DFS(0);
		System.out.println(result);
		sc.close();
	}

	static void DFS(int count) {
		if (count == 3) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					temp[i][j] = map[i][j];
				}
			}
			// 여기에 bfs 들어갑니다.
			visited = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (temp[i][j] == 2) {
						BFS(i, j);
					}
				}
			}
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (temp[i][j] == 0) {
						cnt++;
					}
				}
			}
			result = Math.max(result, cnt);
		} else {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 0) {
						map[i][j] = 1;
						count++;
						DFS(count);
						map[i][j] = 0;
						count--;
					}
				}
			}
		}
	}

	static void BFS(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { x, y });
		visited[x][y] = true;
		while (!queue.isEmpty()) {
			int tmp[] = queue.poll();
			for (int idx = 0; idx < 4; idx++) {// 델타로 사방탐색
				int xd = tmp[0] + dx[idx];
				int yd = tmp[1] + dy[idx];
				if (xd >= 0 && xd < N && yd >= 0 && yd < M && !visited[xd][yd] && temp[xd][yd] == 0) {
					queue.add(new int[] { xd, yd });// 큐에 추가
					visited[xd][yd] = true;
					temp[xd][yd] = 3;
				}
			}
		}
	}
}