import java.util.Scanner;

public class Main {
	static int N;
	static int arr [], tmp[];
	static boolean visited[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int [N];
		tmp = new int [N];
		for(int i = 0; i < N; i++) {
			arr[i] = i+1;
		}
		visited = new boolean[N];
		permutation(0);
		sc.close();
	}
	
	public static void permutation(int depth) {
		if(depth == N) {
			for(int el : tmp) {
				System.out.print(el+" ");
			}System.out.println("");
			return;
		}
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				tmp[depth] = arr[i];
				visited[i] = true;
				permutation(depth+1);
				visited[i] = false;
			}
		}
			
	}
}