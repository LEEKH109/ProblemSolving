import java.util.Scanner;

public class Solution {
	static int arr[][];
	static int dx [] = {1,0,-1,0}; 
	static int dy [] = {0,1,0,-1}; 
	static boolean flag;
	static int end[] = new int [2];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc <= 10; tc++) {
			sc.nextLine();
			arr = new int [16][16];
			int input = -1;
			int start[] = new int [2];
			for (int x = 0; x < 16; x++) {
	            String line = sc.nextLine();
	            for (int y = 0; y < 16; y++) {
	                input = line.charAt(y) - '0';
	                arr[x][y] = input;
	                if (input == 2) {
	                    start[0] = x;
	                    start[1] = y;
	                } else if (input == 3) {
	                    end[0] = x;
	                    end[1] = y;
	                }
	            }
	        }
			flag = false;
			dfs(start, start);
			System.out.println("#"+tc+" "+(flag ? 1 : 0));
		}
		sc.close();
	}
	
	public static void dfs(int start[], int previous[]) {
	    if (flag) return;  // 이미 경로를 찾은 경우 추가 탐색 중단

	    for (int i = 0; i < 4; i++) {
	        int xd = start[0] + dx[i];
	        int yd = start[1] + dy[i];

	        if (xd >= 0 && xd < 16 && yd >= 0 && yd < 16 && arr[xd][yd] != 1 && !(xd == previous[0] && yd == previous[1])) {
	            if (xd == end[0] && yd == end[1]) {
	                flag = true;
	                return;
	            } else {
	                int[] tmp = {xd, yd};
	                dfs(tmp, start);
	            }
	        }
	    }
	}
}