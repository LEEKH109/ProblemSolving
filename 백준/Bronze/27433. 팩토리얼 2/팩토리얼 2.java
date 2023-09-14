import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextInt();
		sc.close();
		System.out.println(f(N));
	}
	public static long f(long N) {
		if(N == 0) {
			return 1;
		}else if(N == 1) {
			return 1;
		}
		return N*f(N-1);
	}
}