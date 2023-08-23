import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		int tc = 10;
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= tc; t++) {
			
			int T = sc.nextInt();
			char[] tmp = new char[T + 1];
			for (int i = 1; i <= T; i++) {
				sc.nextInt();
				tmp[i] = sc.nextLine().charAt(1);
			} // 배열 입력 끝
			System.out.print("#"+t+" "); // V
			preorder(1, T + 1, tmp);
			System.out.println("");
		}
		sc.close();
	}

	public static void preorder(int i, int T, char[] arr) {

		if (i < T) {
			preorder(i * 2, T, arr); // L
			System.out.print(arr[i]); // V
			preorder(i * 2 + 1, T, arr); // R
		}
	}
}