import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N,M;
	static int arr[], tmp[];
	static StringBuilder sb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int [N];
		tmp = new int [M];
		for(int n = 0; n < N; n++) {
			arr[n] = sc.nextInt();
		}//입력 끝
		Arrays.sort(arr);
		dfs(0);
		System.out.println(sb);
		sc.close();
	}
	public static void dfs(int depth) {
		if(depth == M) {
			//출력 구문
			for(int el : tmp) {
				sb.append(el+" ");
			}sb.append("\n");
			return;
		}
		for(int i = 0; i < N; i++) {
			if(depth == 0) {
				tmp[depth] = arr[i];
				dfs(depth+1);
			}else if(tmp[depth-1] <= arr[i]) {
				tmp[depth] = arr[i];
				dfs(depth+1);
			}
		}
	}
}