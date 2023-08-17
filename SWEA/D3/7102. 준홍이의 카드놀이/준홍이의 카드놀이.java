import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		
		for(int tc = 1; tc <= test_case; tc++) {
			int left = sc.nextInt();
			int right = sc.nextInt();
			int[] a = new int[left+right+1]; //6+6+1 이면 인덱스의 최댓값이 12인 배열을 만들 수 있다.
			
			for(int i = 1; i <= left; i++) {
				for(int j = 1; j <= right; j++) {
					a[i+j]++;
				}
			}
			int max = 0;
			for(int i = 2; i <= left+right; i++) {
				max = Math.max(a[i], max);
			}
			StringBuilder sb = new StringBuilder();
            sb.append("#").append(tc).append(" ");
            for (int i = 2; i <= left + right; i++) {
                if (a[i] == max) {
                    sb.append(i).append(" ");
                }
            }
            System.out.println(sb.toString().trim()); 
		}
		sc.close();
	}
}