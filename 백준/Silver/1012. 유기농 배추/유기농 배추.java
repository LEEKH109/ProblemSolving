import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int [][] arr;
	static int M,N,K;
	static boolean [][] visited; 
	static int [] dx = {-1,0,1,0};
	static int [] dy = {0,1,0,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			M = sc.nextInt();
			N = sc.nextInt();
			K = sc.nextInt();
			arr = new int [M][N];
			visited = new boolean [M][N];
			for(int k = 0; k < K; k++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				arr[x][y] = 1;
			}// 배추 심기 완료
			//bfs랑 visited로 풀어야 한다.
			//치즈도둑과 유사한 문제다.
			//덩어리 갯수 구하는 코드다.
			int cnt = 0;
			for(int x = 0; x < M; x++) {
				for(int y = 0; y < N; y++) {
					if(!visited[x][y] && arr[x][y] == 1) {
						bfs(x,y);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
		sc.close();
	}
	
	public static void bfs(int x, int y) {
		Queue<int[]>queue = new LinkedList<int[]>();
		queue.add(new int[] {x,y});
		visited[x][y] = true;
		while(!queue.isEmpty()) {
			int [] tmp = queue.poll();
			for(int i = 0; i < 4; i++) {
				int xd = tmp[0] + dx[i];
				int yd = tmp[1] + dy[i];
				if(xd >=0 && xd < M && yd >=0 && yd < N && arr[xd][yd] == 1 && !visited[xd][yd]) {
					queue.add(new int[] {xd,yd});
					visited[xd][yd] = true;
				}
			}
		}
	}
}