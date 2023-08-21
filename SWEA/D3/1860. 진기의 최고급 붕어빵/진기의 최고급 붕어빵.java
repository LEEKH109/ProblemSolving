import java.util.Arrays;
import java.util.Scanner;
//[ 문제 정의 ]
//M초 동안 K개의 붕어빵을 만들 수 있다.
//N명의 손님이 각각의 시간에 올 때, 모든 손님에게 붕어빵을 제공할 수 있는지 판별한다.
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스의 수
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 손님 수
			int M = sc.nextInt(); // M초에
			int K = sc.nextInt(); // K개의 붕어빵 만들기

			int[] sonnim = new int[N];
			for (int i = 0; i < N; i++) {
				sonnim[i] = sc.nextInt();
			}// 손님 도착 시간 입력 끝

			// 손님 도착 시간 오름차순 정렬
			Arrays.sort(sonnim);//내장 정렬과 사랑에 빠졌습니다. 

			boolean isPossible = true;// 출력 값
			for (int i = 0; i < N; i++) {
				int cakes = (sonnim[i] / M) * K;
				if (cakes < i + 1) {
					isPossible = false;
					break;
				}
			}
			if (isPossible) {
				System.out.println("#" + tc + " Possible");
			} else {
				System.out.println("#" + tc + " Impossible");
			}
		}
		sc.close();
	}
}