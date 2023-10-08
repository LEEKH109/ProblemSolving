import java.util.Arrays;
import java.util.Scanner;

public class Main {
	//순서 고려 + 중복 고려 
	static int N,M;
	static int arr[], tmp[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int [N];
		tmp = new int [M];
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		combination(0,0);
		sc.close();
	}
	public static void combination(int idx, int sidx) {
		// 기저파트
		if (sidx == M) {//필요한 갯수를 다 채운거다 
			for(int el : tmp) {
				System.out.print(el+" ");
			}
			System.out.println("");
			return;
		}
		if (idx == N)
			return;
		// 재귀파트
		tmp[sidx] =arr[idx]; 
		//idx는 무조건 1이 증가해야 한다, 그래야 arr에서 다음 숫자를 가져온다.
		//여기서 증가 하거나 안하거나 해서 경우의 수를 만들어 내는 것은 sidx이다.
		//해당 값을 통해서 tmp 몇 번째 자리에 값을 입력 중인지 체크 할 수 있다.
		combination(idx + 1, sidx + 1);// 위 아래 순서가 바뀌면 안된다. 트리 구조를 그려 보자
		combination(idx + 1, sidx); //
	}
}