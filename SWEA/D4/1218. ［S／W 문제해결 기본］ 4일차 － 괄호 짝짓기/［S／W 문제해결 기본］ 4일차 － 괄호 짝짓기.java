// [ 문제 정의 ]
// 4 종류의 괄호문자들 '()', '[]', '{}', '<>' 로 이루어진 문자열이 주어집니다.
// 서로 짝이 다 맞는지를 검사하는 문제
// 짝이 맞다면 1 하나라도 맞지 않는다면 0을 출력
// [ 입력 ] 
// 테스트 케이스는 10개 고정, 번호가 따로 입력되지는 않습니다.
// 괄호가 총 몇칸인지 입력이 주어집니다.
// 이어서 '()', '[]', '{}', '<>' 가 섞인 문자 입력이 주어집니다.
// [ 주의 사항 ]
// 주의사항1. 테스트 케이스 번호는 1부터
// 주의사항2. 테스트 케이스 6번 같은 함정 문제가 있음, 단순히 이전 입력값과 대응되면 삭제되는 식으로 하면 
//			닫는 괄호가 먼저 나오는 경우 입력을 해야하는데 그냥 넘어가게 되는 문제가 생깁니다.
//			6번이 0인 이유 => {[<(({[{(({[(({{{])}}}))]}))}]}))>]}
// 주의사항3. 스택 내장 메소드를 사용하는 것이 변수를 몇개 더 선언하는 것보다 더 빠를 수 있습니다.
// [ 풀이 방식]
// 입력 값이 8개나 되므로 if문 보다 switch case를 사용하는게 직관적
// 여는 괄호의 입력의 경우 그냥 push해주면 충분
// 닫는 괄호의 경우 비어있는 경우 pop하면 안되므로 스택이 비어있는지 확인
// 스택에 가장 최신 값은 stack.peek으로 확인 / 따로 변수로 받아서 할까 했지만 굳이? 싶습니다.
// 닫는 괄호일때 스택이 비어있는 경우 그냥 이 순간에 연산을 정지합니다. 어차피 규칙이 깨진거니까 걸러줍니다.
// 만약 "}{", "][", ")(","><"도 닫는 걸로 치는 문제라면 다른 방식으로 접근해야 합니다.
// 이 문제는 아니기 때문에 위에 처럼 그냥 합니다.
// 최종적으로 모든 입력을 처리하고 스택이 비어있다면 유효성 체크에 통과 한 것이므로 1을 출력합니다.
// 유효성은 BOOLEAN으로 관리합니다.
// 입력 칸 수가 홀수이면 보나마나 유효성 체크가 실패이므로 연산을 패스합니다.
import java.util.Stack;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int inputLeng = sc.nextInt();
			boolean result = false;
			boolean edge = true;
			char[] tmpArr = new char[inputLeng];
			tmpArr = sc.next().toCharArray();
			if (inputLeng % 2 != 1) {// 작동 로직은 여기서부터
				Stack<Character> cStack = new Stack<>();// 문제에서 사용할 char 스택을 선언한다.
				Loop: for (int i = 0; i < inputLeng; i++) {// 입력된 배열을 순회한다.
					switch (tmpArr[i]) {
					case '(': case '[': case '{': case '<': //여는 괄호는 그냥 스택에 더해주면 끝입니다.
						cStack.push(tmpArr[i]);
						break;
					case ')'://여기서부터 닫는 괄호라 중요합니다.
						if (!cStack.isEmpty() && cStack.peek() == '(') {
							cStack.pop();//같은 쌍이면 빼줍니다.
						} else {
							edge = false;//다른 방식은 cStack.push(tmpArr[i]); 해버려도 됩니다.
							//결과적으로 스택의 길이가 0이 아니므로 동일한 결과가 나올 것 입니다.
							break Loop;
						}
						break;
					case ']'://여기서부터는 동일한 로직입니다.
						if (!cStack.isEmpty() && cStack.peek() == '[') {
							cStack.pop();
						} else {
							edge = false;
							break Loop;
						}
						break;
					case '}':
						if (!cStack.isEmpty() && cStack.peek() == '{') {
							cStack.pop();
						} else {
							edge = false;
							break Loop;
						}
						break;
					case '>':
						if (!cStack.isEmpty() && cStack.peek() == '<') {
							cStack.pop();
						} else {
							edge = false;
							break Loop;
						}
						break;
					default://예외처리
						break;
					}
				}
				if (cStack.empty() && edge) {
					result = true;// 전부 참이면 길이가 0이라는 뜻입니다.
				}
			} // 입력 길이가 홀수면 이미 짝이 맞지 않은 것이므로 굳이 연산 할 필요 없다.
			System.out.println(String.format("#%d %d", tc, result ? 1 : 0));
		} // 테스트 케이스 종료
		sc.close();
	}
}