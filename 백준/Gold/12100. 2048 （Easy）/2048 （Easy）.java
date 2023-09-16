import java.util.Scanner;

public class Main {
	static int N;
	static int max = -1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int[][] game = new int[N][N];
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				game[x][y] = sc.nextInt();
			}
		}
		sc.close();
		move(1, 0, game);
		move(2, 0, game);
		move(3, 0, game);
		move(4, 0, game);
		System.out.println(max);
	}

	public static void move(int direction, int cnt, int[][] arr) {
		if (cnt == 5) {
			int nowMax = 0;
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < N; y++) {
					if (arr[x][y] > nowMax) {
						nowMax = arr[x][y];
					}
				}
			}
			if (nowMax > max) {
				max = nowMax;
			}
			return;
		}

		int[][] tmp = new int[N][N];
		for (int i = 0; i < N; i++) {
			System.arraycopy(arr[i], 0, tmp[i], 0, N);
		}

		switch (direction) {
		case 1: // 위 병합
			mergeUp(tmp);
			//System.out.println("Hellow");
			break;
		case 2: // 아래 병합
			mergeDown(tmp);
			break;
		case 3: // 왼쪽 병합
			for (int i = 0; i < N; i++) {
				tmp[i] = mergeLeft(tmp[i]);
			}
			break;
		case 4: // 오른쪽 병합
			for (int i = 0; i < N; i++) {
				tmp[i] = mergeRight(tmp[i]);
			}
			break;
		}
		for(int i = 1; i <= 4; i++) {
			move(i, cnt + 1, tmp);
		}
	}

	public static int[] mergeLeft(int[] line) {
		int[] merged = new int[N];
		int currentIndex = 0;
		boolean skip = false;

		for (int num : line) {
			if (num != 0) {
				if (currentIndex > 0 && !skip && merged[currentIndex - 1] == num) {
					merged[currentIndex - 1] = num * 2;
					skip = true;
				} else {
					merged[currentIndex++] = num;
					skip = false;
				}
			}
		}
		return merged;
	}

	public static void mergeUp(int[][] board) {
		for (int j = 0; j < N; j++) {
			int[] column = new int[N];

			for (int i = 0; i < N; i++) {
				column[i] = board[i][j];
			}
			int[] mergedColumn = mergeLeft(column);
			for (int i = 0; i < N; i++) {
				board[i][j] = mergedColumn[i];
			}
		}
	}

	public static int[] mergeRight(int[] line) {
		int[] merged = new int[N];
		int currentIndex = N - 1;
		boolean skip = false;

		for (int i = N - 1; i >= 0; i--) {
			if (line[i] != 0) {
				if (currentIndex < N - 1 && !skip && merged[currentIndex + 1] == line[i]) {
					merged[currentIndex + 1] *= 2;
					skip = true;
				} else {
					merged[currentIndex--] = line[i];
					skip = false;
				}
			}
		}
		return merged;
	}
    
	public static void mergeDown(int[][] board) {
		for (int j = 0; j < N; j++) {
			int[] column = new int[N];
			for (int i = 0; i < N; i++) {
				column[i] = board[i][j];
			}
			int[] mergedColumn = mergeRight(column);
			for (int i = 0; i < N; i++) {
				board[i][j] = mergedColumn[i];
			}
		}
	}
}