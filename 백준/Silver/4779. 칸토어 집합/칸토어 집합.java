import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static char [] arr;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(sc.hasNext()) {
			int N = sc.nextInt();
			int M = 1;
			for(int i = 0; i < N; i++) {
				M *= 3;
			}
			arr = new char[M+1];
			if(M != 1) {
				Arrays.fill(arr, ' ');
				dfs(1, M, M);
				for(int i = 1; i <= M; i++) {
					bw.write(arr[i]);
				}
				bw.write("\n");
			} else {
				bw.write("-\n");
			}
		}
		bw.flush(); 
		bw.close();
		sc.close();
	}

	public static void dfs(int start, int end, int M) {
		if(M == 3) {
			arr[start] = arr[end] = '-';
			return;
		}
		int add = M / 3;
		dfs(start,start+add-1,M/3);
//		dfs(start+add,start+2*add-1,M/3);
		dfs(start+2*add,start+3*add-1,M/3);
	}
}