import java.util.Scanner;
//정곤이 나뻐......
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();//전체 테스트케이스 갯수 입력
		for(int tc = 1; tc <= T; tc++) {
			int max = -1;// 직전 최대값을 저장 할 변수 선언 초기값은 0
			int now = 0;// 현재 순간의 값
			int N = sc.nextInt();//이번 테스트케이스에서 입력될 숫자의 횟수
			int [] input = new int [N];// 입력들을 넣어 줄 배열 만들기
			for(int i = 0; i < N ; i++) {
				input[i] = sc.nextInt();
			}//전체 숫자 입력 끝
			// 이제 순서대로 값 비교
			for(int i = 0; i < N-1; i++) {// 어쩔 수 없이 완전 탐색 돌려야 한다.
				for(int j = i+1; j < N; j++) {
					now = input[i]*input[j];
					if(danjo(now)) {
						if(now > max) {
							max = now;
						}
					}
				}
			}
			System.out.println("#"+tc+" "+max); //max가 그대로 -1 이면 단조 함수가 하나도 없었다라는 뜻, 문제에 나온 규칙대로 -1 출력
		}
		sc.close();
	}
	public static boolean danjo(int num) { //해당 숫자가 단조함수인지 확인하는 함수
		int front = num%10;//계속 10으로 나누면서 뒤에서부터 판단
		int remain = num/10;
		int back = 0;
		while(remain > 0) {
			back = remain%10;
			if(back > front) {
				return false;//한번이라도 단조함수 규칙에 어긋나면 false 반환
			}
			front = back;
			remain = remain/10;
		}
		return true;//전부 만족했다면 true 반환
	}
}