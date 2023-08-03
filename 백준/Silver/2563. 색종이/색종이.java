import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 그냥 넓이로 할려고 했는데 그러면 계산이 복해 질 것 같으니 배열 색칠하기로 갑시다
		// 도화지 크기 만큼의 배열을 생성 합시다.
		int [][] board = new int[101][101]; // 초기값으로 배열의 el은 전부 0 입니다.
		// 이제 입력을 받아 줍시다.
		Scanner sc = new Scanner(System.in);
		int inputNum = sc.nextInt();
		for(int i=0; i < inputNum; i++) {
			int left = sc.nextInt(); // 요게 X 좌표 
			int bottom = sc.nextInt(); // 요게 Y 좌표
			for(int x = left; x < left + 10; x++) {
				for(int y = bottom; y < bottom + 10; y++) {
					board[x][y] = 1;
				}
			}
		}
		int result = 0;
		for(int x = 0; x < 101; x++) {
			for(int y = 0; y < 101 ; y++) {
				if(board[x][y] == 1) {
					result++;
				}
			}
		}
		System.out.println(result);
	}
}