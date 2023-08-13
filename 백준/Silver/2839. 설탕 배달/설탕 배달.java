import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int result = -1; // 초기값 설정

        // i는 5킬로그램 봉지의 개수
        for (int i = N / 5; i >= 0; i--) {
            int remainingWeight = N - (i * 5);

            // 남은 무게가 3킬로그램 봉지로 딱 떨어진다면
            if (remainingWeight % 3 == 0) {
                // 5킬로그램 봉지의 개수 + 3킬로그램 봉지의 개수를 결과로 설정
                result = i + (remainingWeight / 3);
                break; // 반복문을 탈출
            }
        }
        System.out.println(result);
    }
}
