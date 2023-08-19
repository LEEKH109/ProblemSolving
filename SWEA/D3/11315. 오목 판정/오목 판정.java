import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <=T; tc++) {
			int N = sc.nextInt();//배열의 길이
			char [][] tmpArr = new char[N][];
			for(int i = 0; i < N; i++) {
				tmpArr[i] = sc.next().toCharArray();
			}//문자 입력 끝 
			int [] dx = {1,0,1,-1};//델타 사용
			int [] dy = {0,1,1,1};//총 4방향만 점검하면 됩니다.
			boolean result = false;
			Loop: for(int y = 0; y < N; y++) {
				for(int x = 0; x < N; x++) {//배열을 완전 탐색 할 겁니다.
					for(int dir = 0; dir < 4; dir++) { //4방위를 돌리기 위한 반복문입니다.
						for(int omok = 0; omok <5; omok++) {
							int xd = x+dx[dir]*omok;
							int yd = y+dy[dir]*omok;
							if(xd < 0 || xd >= N || yd < 0 || yd >= N) {
								break; // 시작좌표가 배열의 범위 밖으로 벗어난 경우 진행하지 않습니다.
							}else if(tmpArr[xd][yd] != 'o') {
								break;
							}else if(tmpArr[xd][yd] == 'o' && omok == 4) {
								result = true;
								break Loop;// 더 찾을 필요가 없다.
							}
						}
					}
				}
			}
			System.out.println(String.format("#%d %s", tc, (result ? "YES" : "NO")));	
		}
		sc.close();
	}
}