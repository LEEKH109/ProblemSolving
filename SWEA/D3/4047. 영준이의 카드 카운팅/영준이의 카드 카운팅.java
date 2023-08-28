import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T;  tc++) {
			int[] tmpS = new int[14];
			int[] tmpD = new int[14];
			int[] tmpH = new int[14];
			int[] tmpC = new int[14];
			char[] input = sc.next().toCharArray();
			boolean error = false;
			Loop : for (int i = 0; i < input.length; i += 3) {
				int num = 0;
				switch (input[i]) {
				case 'S':
					num = num+(input[i+1]-'0')*10+(input[i+2]-'0');
					if(tmpS[num] == 0) {
						tmpS[num]++;
					}else {
						error = true;
						break Loop;
					}
					break;
				case 'D':
					num = num+(input[i+1]-'0')*10+(input[i+2]-'0');
					if(tmpD[num] == 0) {
						tmpD[num]++;
					}else {
						error = true;
						break Loop;
					}
					break;
				case 'H':
					num = num+(input[i+1]-'0')*10+(input[i+2]-'0');
					if(tmpH[num] == 0) {
						tmpH[num]++;
					}else {
						error = true;
						break Loop;
					}
					break;
				case 'C':
					num = num+(input[i+1]-'0')*10+(input[i+2]-'0');
					if(tmpC[num] == 0) {
						tmpC[num]++;
					}else {
						error = true;
						break Loop;
					}
					break;
				}
			}//입력 종료
			String result="#"+tc+" ";
			if(error) {
				result+=("ERROR");
			}else {
				int []  resultArr = {13, 13, 13, 13};
				for(int i = 1; i <= 13; i++) {
					if(tmpS[i] == 1) resultArr[0]--;
					if(tmpD[i] == 1) resultArr[1]--;
					if(tmpH[i] == 1) resultArr[2]--;
					if(tmpC[i] == 1) resultArr[3]--;
				}
				for(int  i = 0; i < 4; i++) {
					result+=(resultArr[i]+" ");
				}
			}
			System.out.println(result);
		}
		sc.close();
	}
}