import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int arr[];
	static int tmp[];
	static boolean[] visit;
	static int N;
	static int M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int [N];
		tmp = new int [M];
		visit = new boolean[N];
		for(int i = 0; i < N; i++) {
			arr[i] = i+1;
		}
		dfs(0,0);
		sc.close();
	}
	public static void dfs(int idx, int depth) {
		if (depth == M) {
			for(int el : tmp) {
				System.out.print(el+" ");
			}
			System.out.println("");
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!visit[i]) {// 방문 처리가 왜 필요할까?
				visit[i] = true;
				tmp[idx] = arr[i];
				dfs(idx+1, depth + 1);// 이 코드는 왜 두 값 모두 증가시켜도 되는지 생각해보자
				visit[i] = false;// 이걸 왜 해줘야 하는지 적어보자 
			}
		}
	}
}