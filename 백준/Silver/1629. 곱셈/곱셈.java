import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long A = sc.nextLong();
		long B = sc.nextLong();
		long C = sc.nextLong();
		long result = cal(A,B,C);
		System.out.println(result);
		sc.close();
	}
	public static long cal(long A, long B, long C) {
		if(B <= 1) {
			return A%C;
		}else if(B%2 ==1) {
			long t=cal(A,B/2,C);
			return cal(A,(B+1)/2,C)%C * t%C;
		}else {
			long t=cal(A,B/2,C);
			return t%C * t%C;
		}
	}//이게 아닌데.......
}
