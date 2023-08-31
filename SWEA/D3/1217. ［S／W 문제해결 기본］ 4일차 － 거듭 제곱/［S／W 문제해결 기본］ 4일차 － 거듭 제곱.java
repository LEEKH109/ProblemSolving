import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		int T = 10;
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc <= T; tc++) {
			int test_case = sc.nextInt();
			int N = sc.nextInt();
			int M = sc.nextInt();
			int result = mul(N,M);
			System.out.println("#"+test_case+" "+result);
		}
		sc.close();
	}
	public static int mul(int N, int M) {
		if(M == 1) {
			return N;
		}else if(M%2 == 0){
			return mul(N,M/2)*mul(N,M/2);
		}else {
			return mul(N,(M+1)/2)*mul(N,M/2);
		}
	}
}
