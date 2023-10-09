import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int arr[], tmp[];
	static int N, M;
	public static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		tmp = new int[M];
		for (int n = 0; n < N; n++) {
			arr[n] = sc.nextInt();
		}
		Arrays.sort(arr);
		dfs(0);
		System.out.print(sb);
		sc.close();
	}

	public static void dfs(int depth) {
		if (depth == M) {
			for (int el : tmp) {
				sb.append(el+" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			tmp[depth] = arr[i];
			dfs(depth + 1);
		}
	}
}