import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int arr[][], dist[][];
	static int dx[] = { 1, 0, -1, 0 }, dy[] = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 0;
		boolean flag = false;
		while (!flag) {
			T++;
			int temp = sc.nextInt();
			if (temp == 0) {
				flag = true;
			} else {
				N = temp;
				arr = new int[N][N];
				dist = new int[N][N];
				for (int x = 0; x < N; x++) {
					for (int y = 0; y < N; y++) {
						arr[x][y] = sc.nextInt();
						dist[x][y] = 987_654_321;
					}
				}
				dist[0][0] = arr[0][0];
				bfs(0, 0);
				System.out.println("Problem " + T + ": " + dist[N - 1][N - 1]);
			}
		}
		sc.close();
	}

	public static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] { x, y });
		while (!queue.isEmpty()) {
			int tmp[] = queue.poll();
			for (int idx = 0; idx < 4; idx++) {
				int xd = tmp[0] + dx[idx];
				int yd = tmp[1] + dy[idx];
				if (xd >= 0 && xd < N && yd >= 0 && yd < N) {
					if (dist[xd][yd] > dist[tmp[0]][tmp[1]] + arr[xd][yd]) {
						dist[xd][yd] = dist[tmp[0]][tmp[1]] + arr[xd][yd];
						queue.add(new int[] { xd, yd });
					}
				}
			}
		}
	}
}
