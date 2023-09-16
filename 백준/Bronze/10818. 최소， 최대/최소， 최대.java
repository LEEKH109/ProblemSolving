import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, input = 0;
        for(int i = 0; i < N; i++) {
        	input = sc.nextInt();
        	if(input > max) max = input;
        	if(input < min) min = input;
        }
        System.out.println(min+" "+max);
        sc.close();
    }
}