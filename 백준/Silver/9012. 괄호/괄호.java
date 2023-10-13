import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 0; tc < T; tc++) {
			Stack<Character>stack = new Stack<>();
			char tmp [] = sc.next().toCharArray();
			boolean flag = false;
			for(char el : tmp) {
				if(el == '(') {
					stack.push('(');
				}else {
					if(stack.size() != 0 && stack.peek() == '(') {
						stack.pop();
					}else {
						flag = true;
						break;
					}
				}
			}
			if(stack.size() != 0) flag = true;
			System.out.println(flag ? "NO" : "YES");
		}
		sc.close();
	}
}