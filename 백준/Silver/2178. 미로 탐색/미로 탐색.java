import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M;
	static int arr[][];
	static int dist[][];
	static boolean visited[][];
	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		dist = new int[N][M];
		for (int x = 0; x < N; x++) {
			char tmp[] = sc.next().toCharArray();
			for (int y = 0; y < M; y++) {
				arr[x][y] = tmp[y] - '0';
			}
		} // 배열 입력 처리
		visited = new boolean[N][M];
		bfs(0,0);
//		for (int x = 0; x < N; x++) {
//			for (int y = 0; y < M; y++) {
//				System.out.print(dist[x][y]);
//			}
//			System.out.println("");
//		}
		System.out.println(dist[N-1][M-1]);
		sc.close();
	}
	// 최소 칸수를 구하는 거라 DFS로 푸는 게 맞다.
	// 아니었다 결과는 확실하게 구할 수 있지만 최악의 경우 시간초과가 발생한다.
	public static void bfs(int x, int y) {
		visited[x][y] = true;
		dist[x][y] = 1;
		Queue<int[]>queue = new LinkedList<int[]>();
		queue.add(new int [] {x,y});
		while(!queue.isEmpty()) {
			int tmp[] = queue.poll();
			for (int idx = 0; idx < 4; idx++) {
				int xd = tmp[0] + dx[idx];
				int yd = tmp[1] + dy[idx];
				if(xd >=0 && xd < N && yd >= 0 && yd < M && arr[xd][yd] == 1 && !visited[xd][yd]) {
					visited[xd][yd] = true;
					queue.add(new int [] {xd,yd});
					if(dist[xd][yd] == 0) {
						dist[xd][yd] = dist[tmp[0]][tmp[1]]+1;
					}
				}
			}
		}
	}
}