import java.util.Scanner;

public class Main {
	static int N, max, min;
	static int[] Narr; // 입력 숫자 담는 배열
	static int[] Oarr; // 연산자 개수 담는 배열

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		Narr = new int[N];
		for (int i = 0; i < N; i++) {
			Narr[i] = sc.nextInt();
		}
		Oarr = new int[4];
		for (int i = 0; i < 4; i++) {
			Oarr[i] = sc.nextInt();
		}
		sc.close();
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		
		dfs(Narr[0], 1); // 초기값은 Narr[0]에서 시작

		System.out.println(max);
		System.out.println(min);
	}

	public static void dfs(int result, int idx) {
		if (idx == N) { // 모든 연산자를 다 사용했을 경우
			max = Math.max(max, result);
			min = Math.min(min, result);
			return;
		}
		for (int i = 0; i < 4; i++) {
			// 연산자가 남아있다면
			if (Oarr[i] > 0) {
				Oarr[i]--;// 횟수 차감 
				switch (i) {
				case 0:
					dfs(result + Narr[idx], idx + 1);
					break;
				case 1:
					dfs(result - Narr[idx], idx + 1);
					break;
				case 2:
					dfs(result * Narr[idx], idx + 1);
					break;
				case 3:
					dfs(result / Narr[idx], idx + 1);
					break;
				}
				Oarr[i]++;// 원복 
			}
		}
	}
}
