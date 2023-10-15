import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Stack<Integer>stack = new Stack<Integer>();
		for(int i = 0; i < N; i++) {
			int tmp = sc.nextInt();
			if(tmp == 0 && !stack.isEmpty()) {
				stack.pop();
			}else {
				stack.push(tmp);
			}
		}
		int sum = 0; 
		while(!stack.isEmpty()) {
			sum+=stack.pop();
		}
		System.out.println(sum);
		sc.close();
	}
}