// [ 문제 정의 ]
// n개의 수를 처리해 8자리의 암호를 생성
// 첫 번째 숫자에서 1빼고 맨 뒤로 보내기
// 그 다음 두 번째 숫자에서는 2빼는 식으로 계속해서 반복
// 그러다 맨 뒤로 보낸 수가 0보다 작아지는 경우 반복 정지
// 단, 0보다 작아지는 결과 가 나와도 그 수는 0으로 보정한다.
// 이 때의 8자리 숫자 값이 암호가 된다.
// [ 주의 사항 ]
// 주의 사항1. 9550 9556 9550 9553 9558 9551 9551 9551 이런식으로 입력되는데 9550가 하나의 숫자다 
// 주의 사항2. 빼는 숫자는 계속 증가하는 것이 아니다 1->2->3->4->5->1 순으로 초기화 된다.
// 주의 사항3. 사이클이라는 개념이 있지만 중요하지 않다. 위의 빼는 숫자 순환만 이해하면 된다.
import java.util.LinkedList; //import
import java.util.Queue; //import
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int test_case = 1 ;test_case <= 10; test_case++ ) {//테케 10개 처리
			int tc = sc.nextInt();//테스트 케이스 번호 입력
			Queue<Integer> queue = new LinkedList<>(); //int형 큐 선언
			// 숫자 입력 8개 처리
			for(int i = 0; i < 8; i++) {
				queue.add(sc.nextInt());
			}
			int cnt = 1;
			while(true) { //계속해서 루프를 돌립니다. 대신 break 조건을 확실하게 넣어 무한루프를 방지합니다.
				int next = queue.poll()-cnt;// poll을 이용해 조회 후 가장 첫 번째 값을 삭제 합니다.
				cnt = (cnt == 5) ? 1 : cnt + 1; // 1->2->3->4->5->1 순으로 숫자가 순회하도록 합니다.
				if(next <= 0) { 
					queue.add(0);// 마지막에 추가하는 숫자가 음수가 되거나 0 이면 0으로 부정 후 더해줍니다.
					break;// 그 후 반복문을 정지합니다.
				}
				queue.add(next);//  평상시에는 위에서 처리한 숫자를 계속 뒤에 추가 해줍니다.
			}
			System.out.println(String.format("#%d %s", tc, queueToString(queue)));
		}
		
		sc.close();
	}
	// 지정된 출력 값에 공백이 있어 스트링 빌더를 사용합니다.
	// 다른 출력 방법도 많습니다.
	private static String queueToString(Queue<Integer> queue) {
        StringBuilder sb = new StringBuilder();
        for (int num : queue) {
            sb.append(num).append(" ");
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);  // 마지막 공백 제거
        }
        return sb.toString();
    }
}