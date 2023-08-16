import java.util.Stack;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int inputLeng = sc.nextInt();
			boolean result = false;
			boolean failToggle = true;
			char[] tmpArr = new char[inputLeng];
			tmpArr = sc.next().toCharArray();
			char beforeEl = '0'; // 직전 값을 기록 할 변수
			if (inputLeng % 2 != 1) {// 작동 로직은 여기서부터
				Stack<Character> cStack = new Stack<>();// 문제에서 사용할 char 스택을 선언한다.
				for (int i = 0; i < inputLeng; i++) {// 입력된 배열을 순회한다.
					switch (tmpArr[i]) {
					case '(':
					case '[':
					case '{':
					case '<':
						cStack.push(tmpArr[i]);
						beforeEl = tmpArr[i];
						break;
					case ')':
						if (!cStack.isEmpty() && cStack.peek() == '(') {
							cStack.pop();
						} else {
							cStack.push(tmpArr[i]);
						}
						break;
					case ']':
						if (!cStack.isEmpty() && cStack.peek() == '[') {
							cStack.pop();
						} else {
							cStack.push(tmpArr[i]);
						}
						break;
					case '}':
						if (!cStack.isEmpty() && cStack.peek() == '{') {
							cStack.pop();
						} else {
							cStack.push(tmpArr[i]);
						}
						break;
					case '>':
						if (!cStack.isEmpty() && cStack.peek() == '<') {
							cStack.pop();
						} else {
							cStack.push(tmpArr[i]);
						}
						break;
					default:
						break;
					}
				}
				if (cStack.empty()) {
					result = true;
				}
			} // 입력 길이가 홀수면 이미 짝이 맞지 않은 것이므로 굳이 연산 할 필요 없다.
			System.out.println(String.format("#%d %d", tc, result ? 1 : 0));
		} // 테스트 케이스 종료
		sc.close();
	}
}