import java.util.Scanner;

public class Main {
	static int N, S, cnt;
	static int[] arr;
	static boolean[] checked;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		arr = new int[N];
		checked = new boolean[N];
		cnt = 0; // 경우의 수 0으로 초기화
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		} // 입력
		powerset(0);
		System.out.println(cnt);
		sc.close();
	}

	public static void powerset(int now) {//dfs
		if (now == N) {
			boolean isEmptySet = true; // 부분집합이 공집합인지 확인하는 변수
	        int sum = 0;
	        for(int i = 0; i < N; i++) {
	            if(checked[i]) {
	                sum += arr[i];
	                isEmptySet = false; // 선택된 원소가 하나라도 있다면 공집합이 아니다.
	            }
	        }
	        if(sum == S && !isEmptySet) cnt++; 
			return;
		}
		//기본값이 false; 이므로 중복해서 하지 맙시다.
		checked[now] = true;
		powerset(now+1);
		checked[now] = false;
		powerset(now+1);

	}
}