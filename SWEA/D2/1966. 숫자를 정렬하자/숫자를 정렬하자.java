import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCaseNum = sc.nextInt();
		for(int i = 1; i <= testCaseNum; i++) {
			int inputCnt = sc.nextInt();
			int[] tmpArr = new int [inputCnt]; 
			for(int j = 0; j < inputCnt; j++) {
				tmpArr[j] = sc.nextInt();
			}
			//이제 밑에서 선언한 정렬함수를 tmpArr에 적용한다.
			tmpArr = sortArr(tmpArr);
			System.out.print("#"+i);
			for(int el : tmpArr) {
				System.out.print(" "+el);
			}//출력 문구입니다.
			System.out.println();
		}
	}
	public static int[] sortArr(int[] arr) {//해당 수업에서 배운 선택 정렬을 구현해 봅니다.
		for(int i = 0; i < arr.length; i++) {
			int minIdx = i;// 기분 좌표를 정해 줍니다. 이 좌표가 변하지 않으면 정렬이 발생하지 않은 것 입니다.
			for(int j = i+1; j < arr.length; j++) {
				if(arr[i] > arr[j]) {
					minIdx = j;
					break;
				}
			}
			//i != j 이므로
			if(minIdx != i) {
				int tmp = arr[i];//여기서부터
				arr[i] = arr[minIdx];
				arr[minIdx] = tmp;//여기까지가 스왑 과정입니다. 기준좌표가 변경 되었을 경우에만 실행됩니다.
				i--;//교환이 일어난다면 시작 지점부터 다시 검사를 실행 할 수 있도록 반복문의 i 를 하나 감소시킵니다.
			}
		}		
		return arr;
	}
}