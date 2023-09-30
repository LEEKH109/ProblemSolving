import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int arr[][] = new int[31][31];
			for (int y = 1; y <= 30; y++) {
				arr[1][y] = y;
				for (int x = 2; x <= 30; x++) {
					arr[x][y] = arr[x][y - 1] + arr[x - 1][y - 1];
				}
			}
			int N = sc.nextInt();
			int M = sc.nextInt();
			System.out.println(arr[N][M]);
		}
		sc.close();
	}
}