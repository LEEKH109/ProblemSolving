import java.util.Scanner;

public class Main {

    static int[] dice = new int[6];  // 주사위의 6면
    static int[][] board;
    static int[] idx = new int[2];
    static int N, M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        board = new int[N][M];
        idx[0] = sc.nextInt();
        idx[1] = sc.nextInt();
        int K = sc.nextInt();
        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                board[n][m] = sc.nextInt();
            }
        }
        for (int k = 0; k < K; k++) {
            int cmd = sc.nextInt();
            move(cmd);
        }
        sc.close();
    }

    public static void move(int cmd) {
        int x = idx[0], y = idx[1];
        switch (cmd) {
        case 1: // 동
            if (y < M - 1) {
                y++;
                int[] tmp = {dice[3], dice[1], dice[0], dice[5], dice[4], dice[2]};
                dice = tmp;
            }
            break;
        case 2: // 서
            if (y > 0) {
                y--;
                int[] tmp = {dice[2], dice[1], dice[5], dice[0], dice[4], dice[3]};
                dice = tmp;
            }
            break;
        case 3: // 북
            if (x > 0) {
                x--;
                int[] tmp = {dice[4], dice[0], dice[2], dice[3], dice[5], dice[1]};
                dice = tmp;
            }
            break;
        case 4: // 남
            if (x < N - 1) {
                x++;
                int[] tmp = {dice[1], dice[5], dice[2], dice[3], dice[0], dice[4]};
                dice = tmp;
            }
            break;
        default:
            break;
        }
        if (x != idx[0] || y != idx[1]) {
            if (board[x][y] == 0) {
                board[x][y] = dice[5];
            } else {
                dice[5] = board[x][y];
                board[x][y] = 0;
            }
            idx[0] = x;
            idx[1] = y;
            System.out.println(dice[0]);
        }
    }
}