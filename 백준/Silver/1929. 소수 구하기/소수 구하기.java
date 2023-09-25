import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt();
		int end = sc.nextInt();
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
		for(int i = start; i <= end; i++) {
			if(tmp[i]) {
				System.out.println(i);
			}
		}
		sc.close();
	}
}