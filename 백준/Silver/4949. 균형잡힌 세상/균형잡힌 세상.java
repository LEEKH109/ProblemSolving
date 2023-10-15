import java.util.Scanner;
import java.util.Stack;
 
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s;
		while(true) {		
			s = sc.nextLine();
			if(s.equals(".")) {	// 종료 조건문 
				break;
			}		
			System.out.println(check(s));
		}
	}
	
	public static String check(String s) {
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < s.length(); i++) {
			char el = s.charAt(i);	// i 번째 문자 
			// 여는 괄호일 경우 스택에 push 
			if(el == '(' || el == '[') {
				stack.push(el);
			}
			// 닫는 소괄호 일 경우 
			else if(el == ')') {
				// 스택이 비어있거나 pop할 원소가 소괄호랑 매칭이 안되는 경우 
				if(stack.empty() || stack.peek() != '(') {
					return "no";
				}
				else {
					stack.pop();
				}
			}
			else if(el == ']') {
				// 스택이 비어있거나 pop할 원소가 대괄호랑 매칭이 안되는 경우 
				if(stack.empty() || stack.peek() != '[') {
					return "no";
				}
				else {
					stack.pop();
				}
			}
		}
		return (stack.isEmpty() ? "yes" : "no");
	}
}