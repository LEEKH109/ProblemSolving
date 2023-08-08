import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCaseCnt = sc.nextInt();
		for(int i = 1; i <= testCaseCnt; i++) {
			int testCaseNum = sc.nextInt();
			int[] tmpArr = new int [101];
			int inputNum;
			for(int j = 0; j < 1_000; j++) {
				inputNum = sc.nextInt();
				tmpArr[inputNum]++;
			}
			int resultInt = 0; 
			for(int k = 100; k >= 0; k--) {
				if(tmpArr[resultInt] < tmpArr[k]) {
					resultInt = k;
				}
			}
			System.out.println(String.format("#%d %d", testCaseNum, resultInt));
		}
	}
}
