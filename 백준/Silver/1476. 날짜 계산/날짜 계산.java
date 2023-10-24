import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int E = sc.nextInt();
		int S = sc.nextInt();
		int M = sc.nextInt();
		int targetNum = 0;
		int cnt = 1;
		while(targetNum == 0) {
			if((cnt-E)%15 == 0 && (cnt-S)%28 == 0 && (cnt-M)%19 == 0 ) {
				targetNum = cnt;
			}
			cnt++;
		}
		System.out.println(targetNum);
		sc.close();
	}
}