import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] paperSize = new int[n][2]; // 0: 가로, 1: 세로
        for(int i=0; i<n; ++i){
            paperSize[i][0] = sc.nextInt();
            paperSize[i][1] = sc.nextInt();
        }
        sc.close();
        // 가로 세로 정렬
        for(int i=0; i<n; ++i){
            if(paperSize[i][0] < paperSize[i][1]){
                int temp = paperSize[i][0];
                paperSize[i][0] = paperSize[i][1];
                paperSize[i][1] = temp;
            }
        }

        // 인덱스 정렬
        Arrays.sort(paperSize, (e1, e2) -> {
            if(e1[0] == e2[0]) return e1[1] - e2[1];
            else return e1[0] - e2[0];
        });

        int ans = 1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1); // 해당 i번째 종이는 무조건 포함된다.

        for(int i=n-1; 0<i; --i){
            for(int k=1; k<=i; ++k){
                int j = i - k;
                if(paperSize[j][1] <= paperSize[i][1] || paperSize[j][1] <= paperSize[i][0] && paperSize[j][0] <= paperSize[i][1]){
                    dp[j] = Math.max(dp[j], dp[i]+1);
                    ans = Math.max(dp[j], ans);
                }
            }
        }
        System.out.print(ans);
    }
	
}
