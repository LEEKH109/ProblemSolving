import java.util.Scanner;

public class Main {
	//NM1에서 제한 조건만 풀어주면 된다. 순서는 dfs안의 반복문이 알아서 정렬 해준다.
	public static int arr[];
	public static int tmp[];
	public static int N;
	public static int M;
	public static StringBuilder sb;
	public static void main(String[] args) {
		sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}
		tmp = new int[M];
		dfs(0,0);
		System.out.print(sb);
		sc.close();
	}

	public static void dfs(int idx, int cnt) {
		if (cnt == M) {
			for(int el : tmp) {
				sb.append(el+" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			if(idx >= 1 && tmp[idx-1] <= arr[i]) {
				tmp[idx] = arr[i];
				dfs(idx + 1, cnt + 1); 
			}else if(idx == 0) {
				tmp[idx] = arr[i];
				dfs(idx + 1, cnt + 1); 
			}
		}
	}
}