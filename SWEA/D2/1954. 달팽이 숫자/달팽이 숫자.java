import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//  import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws IOException {

//		이번에는 입출력 과정을 버퍼드 리더 스트링 빌더를 적용해 보았습니다.
//		Scanner sc = new Scanner(System.in);
//		int tc = sc.nextInt();
//		for (int test_case = 1; test_case <= tc; test_case++) {
//		int arr_size = sc.nextInt();
//		int[][] tmpArr = new int[arr_size][arr_size];
//		이전에 사용한 스캐너 코드도 남겨 놓습니다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		// 이번에는 입출력 과정을 버퍼드 리더 스트링 빌더를 적용해 보았습니다.
		for (int test_case = 1; test_case <= tc; test_case++) {
			int arr_size = Integer.parseInt(br.readLine().trim());
			int[][] tmpArr = new int[arr_size][arr_size];
			// 특정 조건이 되면 숫자를 채워 넣는 방향을 바꾼다.
			// 조건1. 다음 진행 방향이 배열 범위 밖이면 방향을 바꾼다.
			// 조건2. 다음 진행 방향에 숫자가 이미 있다면 방향을 바꾼다.
			int idx = 0;
			int x = 0;
			int y = 0;
			int[] dx = { 0, 1, 0, -1 };// 방향을 오른쪽, 아래, 왼쪽, 위로 변경
			int[] dy = { 1, 0, -1, 0 };// 델타로 방향 정해주는게 if문 4중으로 사용하는 것 보다 좋습니다. 
			// 이부분을 설정해 주는게 이 문제의 핵심입니다.
			for (int i = 1; i <= arr_size * arr_size; i++) {
				tmpArr[x][y] = i;// 이제 0부터 끝까지 숫자를 계속 채워 나갑니다.
				int nextX = x + dx[idx];// 다음 x좌표를 지정해줍니다. 아직 대입은 하지 않습니다.
				int nextY = y + dy[idx];// 다음 y좌표를 지정해줍니다. 아직 대입은 하지 않습니다.
				if (nextX < 0 || nextX >= arr_size || nextY < 0 || nextY >= arr_size || tmpArr[nextX][nextY] != 0) {
					idx = (idx + 1) % 4; // 다른 문제에서도 써먹을 수 있는 트릭입니다. 
					// idx를 0~3 사이로 유지 0 -> 1 / 1 -> 2 / 2 -> 3 / 3 -> 0
					nextX = x + dx[idx];
					nextY = y + dy[idx];
					//제한 조건에 걸린다면 idx를 바꿔 방향을 바꾸고 새로운 x,y 좌표를 지정해줍니다.
				}
				x = nextX;
				y = nextY;
				// 이제 최종적으로 다음 x,y 좌표를 할당해줍니다.
			}
			//이번에는 출력을 스트링 빌더로 뽑습니다.
			sb.append("#").append(test_case).append("\n");
			for (int[] arr : tmpArr) {
				for (int el : arr) {
					sb.append(el).append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.print(sb.toString());
		br.close();// 스캐너와 동일하게 버퍼드 리더도 다 쓰네 꺼줍니다.
	}
}