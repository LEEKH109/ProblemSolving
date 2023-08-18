import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int inputCnt = sc.nextInt();
		int platCnt = sc.nextInt();//이거 만큼 배열을 만들까? 일단 안쓸겁니다.
		int result = 0;
		Stack<Integer>[] stack = new Stack[6];
		for (int i = 0; i < 6; i++) {
		    stack[i] = new Stack<>();
		}
		for(int i = 0; i < inputCnt; i++) {
			int stackNum = sc.nextInt()-1;
			int platIdx = sc.nextInt();
			while(!stack[stackNum].isEmpty() && stack[stackNum].peek() > platIdx) {
		        stack[stackNum].pop();
		        result++;
		        // System.out.println(String.format("%d %d에서 1증가", stackNum+1, platIdx));
		    }

		    if(stack[stackNum].isEmpty() || stack[stackNum].peek() < platIdx) {
		        stack[stackNum].push(platIdx);
		        result++;
		        // System.out.println(String.format("%d %d에서 1증가", stackNum+1, platIdx));
		    }
		}
		System.out.println(result);
		sc.close();
	}
}
