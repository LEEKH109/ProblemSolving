import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N,M;
	static int arr[], tmp[];
	static boolean visited[];
	static StringBuilder sb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int [N];
		visited = new boolean [N];
		tmp = new int [M];
		for(int n = 0; n < N; n++) {
			arr[n] = sc.nextInt();
		}
		Arrays.sort(arr);
		dfs(0,0);
		System.out.println(sb);
		sc.close();
	}
	
	public static void dfs(int now, int depth) {
		if(depth == M) {
			for(int el : tmp) {
				sb.append(el+" ");
			}sb.append("\n");
			return;
		}
		int prev = 0;
		for(int i = now; i < N; i++) {
			if(!visited[i] && prev != arr[i]) {
				prev = arr[i];
				visited[i] = true;
				tmp[depth] = arr[i];
				dfs(i, depth+1);
				visited[i] = false;
			}
		}
	}
}