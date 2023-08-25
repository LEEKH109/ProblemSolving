import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String result = ""; //출력할 결과는 한번에 문자열로 
		for(int i = 1; i <= N ; i++) {
			if(clap(i) == 0) { // 0이 반환되면 3 6 9 대상 숫자가 아니므로 문자열에 그냥 더해준다.
				result+=(i+"");
			}else {//여기서부터는 반환 횟수에 따라 "-"를 달아준다.
				for(int c = 0; c < clap(i); c++) {
					result+="-";
				}
			}
			result+=" ";
		}
		System.out.println(result);
		sc.close();
	}
	public static int clap(int num) {// 해당 숫자가 3 6 9 대상인지 판단하는 함수
		int clapCnt = 0;
		char [] tmp = (num+"").toCharArray(); // 숫자를 다 쪼개서
		for(char el : tmp) { 
			if(el == '3' || el== '6' || el =='9') {
				clapCnt++;// 각각의 숫자들이 3 6 9에 해당 될 때마다 +1
			}
		}
		return clapCnt; // 해당 횟수를 반환
	}
}