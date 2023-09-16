import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			if(N == 0) {
				System.out.println(1+" "+0);
			}else if(N == 1) {
				System.out.println(0+" "+1);
			}else {
				int [][] f = new int [N+1][2];
				f[0][0] = 1;
				f[0][1] = 0;
				f[1][0] = 0;
				f[1][1] = 1;
				for(int i = 2; i <= N; i++) {
					f[i][0] = f[i-1][0]+f[i-2][0];
					f[i][1] = f[i-1][1]+f[i-2][1];
				}
				System.out.println(f[N][0]+" "+f[N][1]);
			}
		}
		sc.close();
	}
}