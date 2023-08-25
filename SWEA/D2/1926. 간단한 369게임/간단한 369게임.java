import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String result = "";
		for(int i = 1; i <= N ; i++) {
			if(clap(i) == 0) {
				result+=(i+"");
			}else {
				for(int c = 0; c < clap(i); c++) {
					result+="-";
				}
			}
			result+=" ";
		}
		System.out.println(result);
		sc.close();
	}
	public static int clap(int num) {
		int clapCnt = 0;
		char [] tmp = (num+"").toCharArray();
		for(char el : tmp) {
			if(el == '3' || el== '6' || el =='9') {
				clapCnt++;
			}
		}
		return clapCnt;
	}
}