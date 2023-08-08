import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCaseCnt = 10;
		int inputCnt = 100;
		for(int i = 1; i <= testCaseCnt; i++){
			int dumpCnt = sc.nextInt();
			int[] tmpArr = new int[inputCnt];
			for(int j = 0 ; j < inputCnt; j++) {
				tmpArr[j] = sc.nextInt();
			}
			for(int test = 0; test < dumpCnt; test++) {
                int maxIdx = 0; //시작 좌표를 서정해준다
				int minIdx = 0;
				for(int k = 0; k < inputCnt; k++) { // 한국 사람이면 제발 for문 씁시다.
					if(tmpArr[k] > tmpArr[maxIdx]) maxIdx = k; //최댓값 바꿔주기
					if(tmpArr[k] < tmpArr[minIdx]) minIdx = k; //최솟값 바꿔주기
				}
				if(tmpArr[maxIdx] - tmpArr[minIdx] == 1 || tmpArr[maxIdx] - tmpArr[minIdx] ==0) {
					break;// 평탄화가 주어진 횟수 이전에 끝나면 멈춘다.
				}
				tmpArr[maxIdx]--;
				tmpArr[minIdx]++;
			}
			int resultMax = 0;
			int resultMin = 101; //오류가 생기지 않게 범위 밖의 수로 지정해준다.
			for(int now = 0; now < inputCnt; now++) {
				if(tmpArr[now] > resultMax) resultMax = tmpArr[now];
				if(tmpArr[now] < resultMin) resultMin = tmpArr[now];
			}//이제 평탄화가 끝난 배열에서 최댓값 최솟값을 찾아서 
			System.out.println("#"+i+" "+(resultMax-resultMin)); //주어진 양식에 맞춰서 출력해준다. 
		}
	}
}
