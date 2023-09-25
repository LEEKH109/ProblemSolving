import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int end = 1_000;
		int cnt = 0;
		boolean [] tmp = new boolean [end+1];
		for(int i = 2; i <= end; i++) {
			tmp[i] = true;
		}
		for(int i = 1; i <=Math.sqrt(end); i++) {
			if(tmp[i]) {
				for(int j = 2*i; j <= end; j+=i) {
					tmp[j] = false;
				}
			}
		}
		for(int i = 0; i < N; i++) {
			int input = sc.nextInt();
			if(tmp[input]) cnt++;
		}
		System.out.println(cnt);
		sc.close();
	}
}