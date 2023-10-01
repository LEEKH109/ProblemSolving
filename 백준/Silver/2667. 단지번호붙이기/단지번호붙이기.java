import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	//치즈 덩어리 쪼개는 문제랑 유사하다.
	static int N;
	static int arr [][];
	static boolean visited[][];
	static int dx [] = {1,0,-1,0};
	static int dy [] = {0,1,0,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int [N][N];
		visited = new boolean [N][N];
		for(int x = 0; x < N; x++) {
			char[] tmp = sc.next().toCharArray();
			for(int y = 0; y < N; y++) {
				arr[x][y] = tmp[y]-'0';
			}
		}
		int cnt = 0;
		List<Integer> tmp = new ArrayList<>();
		for(int x = 0; x < N; x++) {
			for(int y = 0; y < N; y++) {
				if(!visited[x][y] && arr[x][y] == 1) {
					//bfs 들어갈 자리
					tmp.add(bfs(x,y));
					cnt++;
				}
			}
		}
		Collections.sort(tmp);
		System.out.println(cnt);
		for(int i = 0; i < cnt; i++) {
			System.out.println(tmp.get(i));
		}
		sc.close();
	}
	public static int bfs(int x, int y) {
		int cnt = 1;
		Queue<int[]>queue = new LinkedList<int[]>();
		visited[x][y] = true;
		queue.add(new int [] {x,y});
		while(!queue.isEmpty()) {
			int [] tmp = queue.poll();
			for(int idx = 0; idx < 4; idx++) {
				int xd = tmp[0]+dx[idx];
				int yd = tmp[1]+dy[idx];
				if(xd >= 0 && xd < N && yd >= 0 && yd < N && arr[xd][yd] == 1 && !visited[xd][yd]) {
					queue.add(new int [] {xd,yd});
					visited[xd][yd] = true;
					cnt++;
				}
			}
		}
		return cnt;
	}
}