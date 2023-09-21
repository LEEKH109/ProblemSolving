import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int[][] arr;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();

		arr = new int[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a][b] = 1;
			arr[b][a] = 1;
		} // 인접행렬을 만드는 방식 => 이 방식이 리스트 여러개 만드는 방식보다 무엇이 좋은가?
		visited = new boolean[N + 1];// 사용전에 초기화
		dfs(V);
		System.out.println("");
		visited = new boolean[N + 1];// 사용전에 초기화
		bfs(V);
		sc.close();
	}

	public static void dfs(int V) {
		visited[V] = true;// 한번 써 먹었으면 더 못 써먹게 체크
		System.out.print(V + " ");
		// 정지조건 지정
		if (V == arr.length) {
			return; // => 이게 왜 정지조건이냐? arr.length는 가장 마지막 숫자이므로 그게 되었다는 뜻은 멈추라는 뜻
		}
		for (int i = 0; i < arr.length; i++) {
			if (!visited[i] && arr[V][i] == 1) {// visited가 중요하다 저게 체크가 안 되어있으면 무한루프 돈다.
				dfs(i);
			}
		}
	}

	public static void bfs(int V) {
		visited[V] = true;// 한번 써 먹었으면 더 못 써먹게 체크
		System.out.print(V + " ");
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(V);
		while(!queue.isEmpty()) {//큐가 완전히 빌때까지 bfs를 돌린다.
			int tmp = queue.poll();// 들어간 놈을 빼서
			for(int i = 0; i < arr.length; i++) {
				if(!visited[i] && arr[tmp][i] == 1) {
					queue.add(i);
					visited[i] = true;
					System.out.print(i + " ");
				}
			}
		}
	}
}