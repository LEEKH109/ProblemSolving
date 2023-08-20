import java.util.Scanner;

// [ 문제정의 ]
// 1001 * 1001칸으로 구성된 평면에 종이를 여러장 겹치는 문제다.(1001칸인 이유는 x축 y축 때문)
// 입력 손서대로 색종이에 번호를 부여하고 해당 번호로 평면을 색칠하는 방식으로 진행
// 해당 방식으로 진행시 색종이가 겹치는 효과도 구현 가능
public class Main {
	public static void main(String[] args) {
		int N = 1001;
		int[][] board = new int[N][N]; // 색종이가 놓일 평면을 이차원 배열로 설정한다. 초기값은 0이다.
		Scanner sc = new Scanner(System.in); // 입력을 위한 스캐너를 선언한다.
		int paperCnt = sc.nextInt(); // 총 사용되는 색종이의 갯수를 입력 받는다.
		for (int i = 1; i <= paperCnt; i++) {// 1부터 시작하는 이유는 입려되는 색종이 마다 개인 번호를 부여해 관리하는 것 보다는
			// 입력 순서대로 숫자를 입력 범위 만큼 색칠해 버리면 겹치는 것 까지 입력과 동시에 간편하게 적용할 수 있기 때문이다.
			int startX = sc.nextInt();
			int startY = sc.nextInt();// 입력 받을 색종의 시작좌표이다. 우리 배열 기준으로는 최상단 가장 왼쪽좌표이다.
			int lengthX = sc.nextInt();
			int lengthY = sc.nextInt();// 색종이의 각각의 가로길이 세로길이 이다.
			for (int y = startY; y < startY + lengthY; y++) { // 색종이가 경계 밖으로 나가지 않는다는 전제조건이 있기에 따로 범위 제한을 하지 않는다.
				for (int x = startX; x < startX + lengthX; x++) {
					board[x][y] = i;
				}
			}
		} // 전체 색종이 입력 끝
//		디버깅 용 테스트 코드
//		System.out.println("");
//		for (int y = 0; y < N; y++) {
//			for (int x = 0; x < N; x++) {
//				System.out.print(board[x][y] + " ");
//			}
//			System.out.println("");
//		}
		// 여기서 부터는 결과 출력 단
		for(int p = 1; p <= paperCnt; p++) {
			int result = 0;
			for (int i = 0; i < 1001; i++) {
				for (int j = 0; j < 1001; j++) {
					if (board[i][j] == p) {
						result++;
					}
				}
			}
			System.out.println(result);
		}
	}
}