// 초벌 코드
// [ 문제 정의 ]
// '(',')' 연달아 나오면 얘는 레이저
// '(','(' 이렇게 세팅되어 있는 경우는 막대
// 직접 그려봐야 이해할 수 있는 문제
// [ 입력 ]
// 입력이 한줄로 들어옵니다.
// String으로 받아서 char배열으로 만들어줍니다.
// [ 풀이 방식 ]
// 총 3가지 페턴이 있습니당
// 패턴1. '('가 나오는 경우 => 그냥 스택에 넣어두면 됩니다.
// 패턴2. ')'가 나오고 직전 값이 '(' 인 경우 =>레이저 입니다
//       => 앞에 있던 (((( 이런 애들이 전부 막대기 이므로 앞에 있던 '(' 갯수만큼 sum에 더해줍니다.
// 패턴3.  ')'가 나오고 직전 값이 ')' 인 경우 => 막대기 영역입니다.
//		 => ')'에 대응되는 '('를 날려줘야 합니다. stack에서 pop해줍니다. 보정을 위해 1더해줍니다.
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		for(int tc = 1; tc <= test_case; tc++) {
			int sum = 0;
			char [] tmpArr = sc.next().toCharArray();
			Stack<Character> stack = new Stack<>();
			for(int i = 0; i < tmpArr.length; i++) {
				if(tmpArr[i] == '(') {
					stack.push('(');
				}else if(tmpArr[i] == ')' && tmpArr[i-1]  == '(') {
					stack.pop();
					sum+=stack.size();
				}else if(tmpArr[i] == ')' && tmpArr[i-1]  == ')') {
					stack.pop();
					sum+=1;
				}
			}
			System.out.println(String.format("#%d %d", tc, sum));
		}
		sc.close();
	}
}