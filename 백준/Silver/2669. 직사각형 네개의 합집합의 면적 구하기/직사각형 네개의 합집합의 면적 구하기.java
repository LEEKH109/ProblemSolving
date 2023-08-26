import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 이 문제는 이미 아는 유형이라 빨리 풀 수 있는 경우이입니다. 백준 색종이와 유사한 유형입니다.
		Scanner sc = new Scanner(System.in);
		int [][] board = new int [101][101];
		for(int i = 0; i < 4; i++) {
			int startX = sc.nextInt();
			int startY = sc.nextInt();
			int endX = sc.nextInt();
			int endY = sc.nextInt();
			for(int x = startX; x < endX; x++) {
				for(int y = startY; y < endY; y++) {
					board[x][y] = 1;
				}
			}
		}
		int result = 0;
		for(int x = 0; x < 100; x++) {
			for(int y = 0; y < 100; y++) {
				if(board[x][y] == 1) result++;
			}
		}
		System.out.println(result);
		sc.close();
	}
}