import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		double max = -1;
		double sum = 0;
		double input = -1;
		for(int i = 0; i < N; i++) {
			input = sc.nextInt();
			if(input > max) {
				max = input;
			}
			sum+=input;
		}//성적 전체 입력과 최댓값 입력 완료
		double aver = (sum*100)/(N*max);
		System.out.println(Math.round(aver*1_000_000)/1_000_000.0);
		sc.close();
	}
}