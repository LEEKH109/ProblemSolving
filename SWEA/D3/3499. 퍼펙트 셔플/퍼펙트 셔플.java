import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 반 둑 잘라서 순서대로 배치시키면 되는 것 아닌가 하는 문제 
// [ 문제 정의 ]
// 퍼펙트 셔플을 해야 합니다. 카드 덱을 반으로 나눠서 번갈아서 섞는 것을 의미 합니다.
// 짝수 카드 덱일 때는 절반1, 절반2로 나눠서 절반1의 첫번째 카드가 맨 앞에 오게 배열 합니다.
// 1 2 3 4 5 6 => [1,2,3] [4,5,6] => [1,4,2,5,3,6]
// 홀수 카드 덱일 때는 첫번째 덱이 1개 더 많게 나눕니다.
// 1 2 3 4 5 6 7 => [1, 2, 3, 4][5, 6, 7] => [1, 5, 2, 6, 3, 7, 4]
// [ 풀이 방식 ]
// 이게 큐를 쓰는게 맞는지 모르겠습니다.
// 간식을 뭘 먹어야 할까요. 고민이에요 곰곰곰
// 단순 배열로 풀게되면 배열 2개에 번갈아서 입력을 받은 후에 순서대로 순회화면서 출력해주면 됩니다.
// 아니면 같은 방식으로 큐 2개에 번갈아서 입력을 받은 후에 순서대로 번갈아서 poll해주면 됩니다.
// 이번에는 두 번째 방식을 적용해 보겠습니다.
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		for(int tc = 1; tc <= test_case; tc++) {
			Queue<String> queue1 = new LinkedList<>(); //int형 큐 선언
			Queue<String> queue2 = new LinkedList<>(); //int형 큐 선언
			int length = sc.nextInt();
			sc.nextLine();
			String [] tmpArr = sc.nextLine().split(" ");
			for(int i = 0; i < length; i++) {
				if(i <= (length-1) / 2) {
					queue1.add(tmpArr[i]);
				}else {
					queue2.add(tmpArr[i]);
				}
			}// 카드 덱을 2개로 나누어 구분해서 큐 2개에 구분해서 담아주기 끝 
			// 좀 마이마이마이마이 귀찮은 출력 부분
			// 이게 이렇게 길게 만들 코드가 아닌데 
			StringBuilder sb = new StringBuilder();
            sb.append("#").append(tc);
            for(int i = 0; i < length; i++) {
                if(i%2 == 0) {
                    sb.append(" ").append(queue1.poll());
                } else {
                    sb.append(" ").append(queue2.poll());
                }
            }
            System.out.println(sb);
		}
		sc.close();
	}
}