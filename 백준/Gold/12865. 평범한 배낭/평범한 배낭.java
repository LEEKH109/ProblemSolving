import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 물품의 수 N

        int K = sc.nextInt(); // 준서가 버틸 수 있는 무게 K

        int [][] stuff = new int [N][2]; // 물건 정보 담을 배열 stuff

        // 0번 인덱스는 무게 W, 1번 인덱스는 가치V

        for(int i = 0; i < N; i++) {

            stuff[i][0] = sc.nextInt();

            stuff[i][1] = sc.nextInt();

        }

        // 여기 까지가 입력 처리 끝

        int [] dp = new int [K+1];

        // K무게 만큼 배열을 생성 하기 때문에 1차원 배열로도 충분하다.

        // dp[K]의 값이 해당 무게에서의 최고 가치이다.

        for(int n = 0; n < N; n++) {

            for(int k = K; k >= 1; k-- ) {

                if(stuff[n][0] <= k) { // 제한조건 일단 해당 무게보다 작거나 같은 물건들만 체크

                    dp[k] = Math.max(dp[k], dp[k-stuff[n][0]] + stuff[n][1]);

                }

            }

        }

        System.out.println(dp[K]);

        sc.close();

    }

}