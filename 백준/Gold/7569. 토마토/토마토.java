import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int M, N, H;//
	static int[][][] box;// 토마토들의 초기 상태를 담아 놓을 삼3차원 배열 스태틱으로 선언
	// 이 문제는 한번 탐색 때마다 6방향 탐색을 해야 한다. => 3차원 상화좌우앞뒤
	static int[] dx = { 0, 0, 0, 0, 1, -1 };
	static int[] dy = { 0, 0, 1, -1, 0, 0 };
	static int[] dz = { 1, -1, 0, 0, 0, 0 };

	// 이문제는 최단거리 최소시간 유형이라 DFS보다는 BFS로 푸는게 맞고, DFS로는 해봤는데 안된다.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);// 입력을 위한 스캐너 선언
		M = sc.nextInt();// y축 가로
		N = sc.nextInt();// x축 세로
		H = sc.nextInt();// x축 세로
		box = new int[N][M][H];// 배열 초기화
		for (int z = 0; z < H; z++) {
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < M; y++) {

					box[x][y][z] = sc.nextInt();

				} // 이제는 올바르게 된 내 배열
			}
		} // 입력 끝
		bfs();
		// 한번 돌리면 각각의 배열의 값은 그 토마토가 익은데 소요된 날짜-1이다.
		int day = 0;
		//3차원 배열은 입력도 어렵다.
		for (int z = 0; z < H; z++) {
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < M; y++) {
					if (box[x][y][z] == 0) {
						System.out.println(-1);
						return;// 싹 돌았는 0이 하나라도 있으면 -1 반환
						// why? 문제 조건에서 하나라도 못 익은게 있으면 -1 출력하라고 했다.
					}
					day = Math.max(day, box[x][y][z]);// 값 계속 비교
				}
			}
		}
		System.out.println(day - 1);
		// 왜 1빼주냐면 +1은 익은 토마토는 무조건 가지고 있는 값이니까 or 초기 배열은 0일로 잡으니까 두 가지로 해석을 해볼 수 있다.
		sc.close();// 끝났으면 닫아주고
	}

	public static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		// bfs는 큐,링크드리스트를 자료형으로 많이 사용한다.

		for (int z = 0; z < H; z++) {
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < M; y++) {
					if (box[x][y][z] == 1) {// 초기 입력에서 익은 토마토를 의미
						queue.offer(new int[] { x, y, z });// 큐에 익은 토마토들 좌표값을 순서대로 넣어준다.
						// 큐하나에 좌표값을 둘 다 넣으려면 배열이 맞는 것 같다.
					}
				}
			}
		}

		while (!queue.isEmpty()) {// 큐가 빌 때까지 => 남은 값이 없을 때까지
			int[] current = queue.poll();// 하나씩 뽑아서 현재값으로 지정

			for (int i = 0; i < 6; i++) {// 델타 사용해 상하좌우앞뒤 6방 탐색
				int nx = current[0] + dx[i];// 이렇게 안해도 되지만 코드가 너무 길어지니까
				int ny = current[1] + dy[i];
				int nz = current[2] + dz[i];

				if (nx >= 0 && ny >= 0 && nz >= 0 && nx < N && ny < M && nz < H) {// 배열 범위 초과 방지
					if (box[nx][ny][nz] == 0) {
						queue.offer(new int[] { nx, ny, nz });// 6방으로 돌면서 주변에 안 익은 토마토를 찾는다.
						// 이 밑에 줄이 이 코드의 핵심 파트 이것 때문에 큐를 사용한다.=> 순서가 중요해서
						box[nx][ny][nz] = box[current[0]][current[1]][current[2]] + 1;// 해당 토마토를 익게 한다.
						// 단, 그냥 익는게 아니라 기준 토마토의 값+1로 익혀준다. => 누적합 비스므리하게
						// 이제 해당 토마토도 익은 토마토이고 큐에 들어갔기 때문에 기존큐에 쌓여있던 좌표들이 전부 처리가 되어야 튀어나온다.
						// 이제는 배열의 값이 1이 아니어도 6방만 유요한 좌표면 계속 추가되는 구조이다.
						// 전부 다 돌아서 더 이상 큐에 쌓일 좌표가 없고, 쌓인 좌표도 없을 때까지 반복한다.
						// 이렇게 되면 배열에서 가장 큰 값-1이 최소 시간이 된다.
					}
				}
			}
		}
	}
}
