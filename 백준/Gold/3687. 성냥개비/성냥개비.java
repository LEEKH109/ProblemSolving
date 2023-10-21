import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			String dpMax[] = new String [N+1];
			long dpMin[] = new long [N+1];
			Arrays.fill(dpMin, Long.MAX_VALUE);
			// 0번째 값 => 최대값
			// 1번째 값 => 최솟값
			for(int i = 2; i <= N; i++) {
				if(i == 2) {
					dpMax[i] = "1"; 
				}else if(i == 3) {
					dpMax[i] = "7";
				}else {
					dpMax[i] = dpMax[i-2]+"1";
				}
			}
			//여기까지가 최대값
			long tmp[] = new long [] {0,0,1,7,4,2,6,8,10};
			long add[] = new long [] {0,0,1,7,4,2,0,8};
			for(int i = 2; i <= N; i++) {
				if(i <= 8) {
					dpMin[i] = tmp[i];
				}else {
					for(int j = 2; j <= 7; j++) {
						dpMin[i] = Math.min(dpMin[i], dpMin[i-j]*10+add[j]);
					}
				}
			}
			System.out.println(dpMin[N]+" "+dpMax[N]);
		}
		sc.close();
	}
}