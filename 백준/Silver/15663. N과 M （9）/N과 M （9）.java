import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, M;
	static int arr[], tmp[];
	static boolean visited[];
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		visited = new boolean[N];
		tmp = new int[M];
		
		for (int n = 0; n < N; n++) {
			arr[n] = sc.nextInt();
		}
		Arrays.sort(arr);
		dfs(0);
		System.out.println(sb);
		sc.close();
	}

	public static void dfs(int depth) {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(tmp[i] + " ");
			}
			sb.append("\n");
			return;
		}
		//이 문제의 핵심 prevNum 이건 직접 트리구조를 그려봐야 이해 할 수 있다.
		int prevNum = 0;
		for (int i = 0; i < N; i++) {
			if(!visited[i] && prevNum != arr[i]) {
				prevNum = arr[i];
				tmp[depth] = arr[i];
				visited[i] = true;
				dfs(depth + 1);
				visited[i] = false;
			}
		}
	}
}