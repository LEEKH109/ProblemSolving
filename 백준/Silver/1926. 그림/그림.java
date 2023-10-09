import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	//이번에는 main안에서 bfs 돌려보자
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int map [][] = new int [N][M];
		for(int x = 0; x < N; x++) {
			for(int y = 0; y < M; y++) {
				map[x][y] = sc.nextInt();
			}
		}
		int total = 0;
		int max = 0;
		boolean visited [][] = new boolean [N][M];
		int dx[] = {1,0,-1,0};
		int dy[] = {0,1,0,-1};
		Queue<int[]>queue = new LinkedList<int[]>();
		for(int x = 0; x < N; x++) {
			for(int y = 0; y < M; y++) {
				if(!visited[x][y] && map[x][y] == 1) {
					total++;
					int cnt = 0;
					visited[x][y] = true; 
					queue.add(new int[] {x,y});
					while(!queue.isEmpty()) {
						int tmp[] = queue.poll();
						cnt++;
						for(int idx = 0; idx < 4; idx++) {
							int xd = tmp[0] + dx[idx];
							int yd = tmp[1] + dy[idx];
							if(xd >= 0 && xd < N && yd >= 0 && yd < M && !visited[xd][yd] && map[xd][yd] == 1) {
								queue.add(new int[] {xd, yd});
								visited[xd][yd] = true;
							}
						}
						
					}
					max = Math.max(max, cnt);
				}
			}
		}
        System.out.println(total);
		if(total == 0) {
			System.out.println(0);
		}else {
			System.out.println(max);
		}
		sc.close();
	}
}	