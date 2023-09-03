import java.util.Scanner;

public class Solution {
	static int N, B;
	static int[] clerk;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			B = sc.nextInt();
			clerk = new int[N];
			for (int i = 0; i < N; i++) {
				clerk[i] = sc.nextInt();
			}
			int minValue = Integer.MAX_VALUE;
			for (int i = 0; i < 1 << N; i++) {
				int sum = 0;
				for (int j = 0; j < N; j++) {
					if ((i & (1 << j)) != 0) {
						sum+=clerk[j];
					}
				}
				if(sum >= B) {
					minValue = Math.min(minValue, sum);
				}
			}
			System.out.println("#"+tc+" "+(minValue-B));
		}
		sc.close();
	}
}