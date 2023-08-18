import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);// 입력 받을 스캐너 켜주기
		int n = sc.nextInt();
		int[] balloon = new int[n];
		int[] idx = new int[n]; // 풍선이 터진 자리는 -1 아직 남아있는 자리는 0으로 처리해준다.
		int[] result = new int [n];
		for (int b = 0; b < n; b++) {
			balloon[b] = sc.nextInt();
		} // 입력 처리 끝
		
		int startIdx = 0;
		int cnt = 0;
		while (remainBallon(idx) > 0) {
			idx[startIdx] = -1; // 현재 위치의 풍선을 터트립니다.
			result[cnt++] = startIdx+1;
			if (remainBallon(idx) == 0) { // 모든 풍선이 터졌을 때 loop을 빠져나옵니다.
				break;
			}

			int nextStep = balloon[startIdx]; // 터트린 풍선 안의 종이에 적힌 수만큼 이동합니다.
			if (nextStep > 0) {
				while (nextStep > 0) {
					startIdx = (startIdx + 1) % n;
					if (idx[startIdx] == 0) {
						nextStep--;
					}
				}
			} else {
				while (nextStep < 0) {
					startIdx = (startIdx - 1 + n) % n;
					if (idx[startIdx] == 0) {
						nextStep++;
					}
				}
			}
		}
		for (int i = 0; i < n; i++) {
		    System.out.print(result[i] + " ");
		}
		System.out.println(); 
		sc.close();// 스캐너 꺼주기
	}

	public static int remainBallon(int[] idx) {
		int cnt = 0;
		for (int el : idx) {
			if (el == 0) {
				cnt++;
			}
		}
		return cnt;
	}
}