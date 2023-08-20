import java.util.Scanner;

public class Solution {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);// 입력을 위한 스캐너 선언
		int T = sc.nextInt(); // 전체 테스트 케이스 수 입력
		for(int tc = 1; tc <= T; tc++) {
			int startM = sc.nextInt();
			int startD = sc.nextInt();
			int endM = sc.nextInt();
			int endD = sc.nextInt();
			int result = dayConvert(endM, endD)-dayConvert(startM, startD)+1;
			System.out.println(String.format("#%d %d", tc, result));
		}
		sc.close();
	}
	public static int dayConvert(int month, int day) {
		int returnDay = 0;
		switch (month-1) {
		case 12:
			returnDay+=31;
		case 11:
			returnDay+=30;
		case 10:
			returnDay+=31;
		case 9:
			returnDay+=30;
		case 8:
			returnDay+=31;
		case 7:
			returnDay+=31;
		case 6:
			returnDay+=30;
		case 5:
			returnDay+=31;
		case 4:
			returnDay+=30;
		case 3:
			returnDay+=31;
		case 2:
			returnDay+=28;
		case 1:
			returnDay+=31;
		default:
			break;
		}
		return returnDay+day;
	}
}