import java.util.Scanner;

public class Solution {
	static boolean [] checked;
	static int [][] food;
	static int maxTaste;
	static int N, L;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();// 테스트케이스 수 입력
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			L = sc.nextInt();
			maxTaste = 0;
			food= new int [N][2];
			checked = new boolean [N];
			for(int i = 0; i < N; i++) {
				food[i][0] = sc.nextInt();// 맛에 대한 점수
				food[i][1] = sc.nextInt();// 칼로리
			}
			powerset(0);
			System.out.println("#"+tc+" "+maxTaste);
		}
		sc.close();
	}
	
	public static void powerset(int now) {
		if(now == N) {
			int cal = 0;
			int sumTaste = 0;
			for(int i = 0; i < N; i++) {
				if(checked[i]) {
					sumTaste+=food[i][0];
					cal+=food[i][1];
				}
			}
			if(cal<= L) {
				maxTaste = Math.max(maxTaste, sumTaste);
			}
			return;
		}
		checked[now] = false;
		powerset(now+1);
		checked[now] = true;
		powerset(now+1);
	}
}