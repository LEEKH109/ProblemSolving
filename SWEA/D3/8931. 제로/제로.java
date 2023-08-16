// [ 문제 정의 ]
// 동아리의 지출 금액을 세는 문제
// 0이 입력되면 이전 값은 잘못 부른 값이라고 가정하고 삭제한다.
// [ 입력 ] 
// 전체 테스트 케이스 갯수 입력 후
// 해당 테스트 케이스의 입력 갯수와 이어서 순차적으로 숫자들이 입력된다.
// [ 주의 사항 ]
// 주의사항1. 테스트 케이스 번호는 반복문의 tc번호를 출력해야된다.
// 주의사항2. stack의 내용물을 출력 할 때는 while문을 사용해서 빌때까지 꺼내는 방식을 사용해야 한다.
// [ 풀이 방식]
// 배열을 사용해서 풀 면 더 빠르 지만, 스택으로 풀어보겠습니다.
// 순서대로 입력을 스택에 넣어주고push
// 0이 나오면 스택이 비어있지는 않은지 확인empty하고 최근 입력값 제거 pop
// 최종적으로 결과값은 스택 안에 남아있는 값을 스택이 완전히 빌 때까지 반복 적으로 빼줍니다.
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		int result = 0;
		for (int tc = 1; tc <= test_case; tc++) {
			result = 0;
			Stack<Integer> stack = new Stack<>();
			int inputCnt = sc.nextInt();
			for (int i = 0; i < inputCnt; i++) {
				int input = sc.nextInt();
				if (input == 0 && !stack.isEmpty()) {
					stack.pop();
				} else {
					stack.push(input);
				}
			}
			while (!stack.empty()) {
				int last = stack.pop();
				result += last;
			}
			System.out.println(String.format("#%d %d", tc, result));
		} // 데스트 케이스 순회 끝
		sc.close();
	}
}