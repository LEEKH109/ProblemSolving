import java.util.Scanner;
//원재는 컴퓨터 고장나는 것도 모르면서 무슨 미래를 본다고.......
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int[] tmp = new int[N];
            for(int i = 0; i < N; i++) {
                tmp[i] = sc.nextInt();
            }
            long sum = 0; // 이익이 큰 경우를 위해 long으로 선언
            int max = 0; // 현재까지의 최대값
            for(int i = N - 1; i >= 0; i--) {
                if(tmp[i] > max) {
                    max = tmp[i];
                } else {
                    sum += (max - tmp[i]);
                }
            }
            System.out.println("#" + tc + " " + sum);
        }
        sc.close();
    }
}