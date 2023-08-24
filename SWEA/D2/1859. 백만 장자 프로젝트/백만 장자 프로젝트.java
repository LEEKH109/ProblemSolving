import java.util.Scanner;
//원재는 컴퓨터 고장나는 것도 모르면서 무슨 미래를 본다고.......
public class Solution {
	public static void main(String[] args) {
// 		이건 시간초과난 코드 => 시간초과난 이유 범위가 큰데 반복문을 여러번 돌려서 복잡도 터졌습니다.
//		Scanner sc = new Scanner(System.in);
//		int T = sc.nextInt();// 테스트 케이스 갯수 입력
//		for(int tc = 1; tc <= T; tc++) {
//			int N = sc.nextInt();// 입력의 갯수
//			int[] tmp = new int [N];
//			for(int i = 0; i < N; i++){
//				tmp[i] = sc.nextInt();
//			}// 배열 입력 끝
//			int sum = 0;
//			for(int i = 0; i < N; i++) {
//				int max = tmp[i];
//				for(int j = i+1; j < N; j++) {
//					if(tmp[j] > max) {
//						max = tmp[j];
//					}
//				}
//				//순회에서 기준 좌표 이후에서 최댓값을 찾았다면
//				if(max != tmp[i]) {//다르다면 최댓값을 찾았다는 
//					sum+=(max - tmp[i]);
//				}//다르지 않으면 더 비싸게 팔 기회가 없다는 뜻이므로 바로 팔아야 해서 그냥 계산 할 필요도 없다.	
//			}// 순회 끝
//			System.out.println("#"+tc+" "+sum);
//		}
//		sc.close();
//		이건 통과 코드
		Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int[] tmp = new int[N];
            for(int i = 0; i < N; i++) {
                tmp[i] = sc.nextInt();
            }//여기까지는 입력 받는 것까지 똑같
            long sum = 0; // 이익이 큰 경우를 위해 long으로 선언
            int max = 0; // 현재까지의 최대값
            for(int i = N - 1; i >= 0; i--) {//띵스 국밥 풀이 정방향으로 안되면 역방향으로
            	//뒤에서부터 최댓값 찾기
                if(tmp[i] > max) {
                    max = tmp[i];//최댓값 찾으면 갱신, 최댓값에서는 그날 사서 그날 팔아버리므로 더해 줄 것이 없다.
                } else {
                    sum += (max - tmp[i]);// 최댓값이 아니므로 위에서와 동일하게 차이만큼 더해주기
                }
            }
            System.out.println("#" + tc + " " + sum);
        }
        sc.close();
	}
}