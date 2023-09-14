import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		System.out.println(p(N));
	}
	public static int p(int n) {
		if(n == 0) {
			return 0;
		}else if(n == 1) {
			return 1;
		}
		return p(n-1)+p(n-2);
	}
}