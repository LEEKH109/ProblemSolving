import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();//테스트 케이스 입력
        for (int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();// 1 ≤ N ≤ 30
            int m = sc.nextInt();// 0 ≤ M ≤ 10^8
            int t = (1 << n) - 1;// n번 이동
            System.out.println("#" + tc + " " + ((m & t) == t ? "ON" : "OFF"));
        }
        sc.close();
	}
}