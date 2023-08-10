import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for( int test_case = 1; test_case <= 10; test_case++ ) {
			int tcNum = sc.nextInt();
			int n = 100;
			int [][]tmpArr = new int[n][n];
			for(int y = 0; y < n;  y++) {
				for(int x = 0; x < n; x++) {
					tmpArr[x][y] = sc.nextInt();
				}
			}
			int max = 0;
			for(int i = 0; i <= n; i++) {
				int sumRow = 0;
				int sumColumn = 0;
				if(i != n) {
					for(int j = 0; j < n; j++) {
						sumRow+=tmpArr[i][j];
						sumColumn+=tmpArr[j][i];
					}
				}else {
					for(int j = 0; j < n; j++) {
						sumRow+=tmpArr[j][j];
						sumColumn+=tmpArr[j][n-1-j];
					}
				}
				max = Math.max(max, sumRow);
				max = Math.max(max, sumColumn);
			}
			System.out.println("#"+test_case+" "+max);
		}
		sc.close();
	}
}