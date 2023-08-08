import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCaseCnt = sc.nextInt();
		for(int i = 1; i <= testCaseCnt; i++) {
//			방법1) 배열을 입력받은 후 에 처리
//			int sum = 0;
//			//배열을 입력받으면서 총 합을 더 해줄 변소를 선언
//			int input;
//			int[] arr = new int[10];
//			for(int j = 0; j < 10; j++) {
//				input = sc.nextInt();
//				arr[j] = input;
//				sum+=input;
//			} 총 10번의 입력 처리를 배열로 받아준다.
//			int max = 0;
//			for(int el : arr) {
//				if(el > max) {
//					max = el;
//				}
//			}//배열을 순회하며서 최댓값을 찾는다.
//			int min = 10_001;
//			for(int el : arr) {
//				if(el < min) {
//					min = el;
//				}
//			}//배열을 순회하면서 최솟값을 찾는다.
//			int resultAvg = (int)Math.round((sum-max-min)/8.0);  // 전체 합에서 최댓값과 최솟값 만을 빼준다.
//			System.out.println(String.format("#%d %d",i, resultAvg));
//			방법2) 입력받으면서 처리 배열을 사용하지 않는다.
			int sum = 0; // 입력값 들의 총 합을 저장해준다.
			int input; // 스캐너 입력을 받아 줄 변언을 선언만 한ㄷ.
			int max = -1;// 입력 범위 밖의 최솟값으로 초기화해준다. 그래야 최초 입력값이 바로 들어간다.
			int min = 10_001;// 입력 범위 밖의 최댓값으로 초기화해준다. 그래야 최초 입력값이 바로 들어간다.
			for(int j = 0; j < 10; j++) {// 총 10번의 입력 처리
				input = sc.nextInt();
				if(input > max) {
					max = input;
				}//최댓값 처리
				if(input < min) {
					min = input;
				}//최솟값 처리
				sum+=input;
			}// 총 10번의 입력이 끝나면 전체 입력의 총합 / 최댓값 / 최솟값이 구해진다.
			int resultAvg = (int)Math.round((sum-max-min)/8.0); // 전체 합에서 최댓값과 최솟값 만을 빼준다. 한중이 행님의 은총	
			System.out.println(String.format("#%d %d",i, resultAvg));
		}
	}
}