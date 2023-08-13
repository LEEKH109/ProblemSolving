import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Solution {
    static class Qnum {
        int x, y, direction, counter;
        Qnum(int x, int y, int direction, int counter) {
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.counter = counter;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int test_case = scanner.nextInt();
        int[] dx = {0, 1, 1, 1}, dy = {1, 1, 0, -1}; // 오른쪽, 오른쪽 대각선 아래, 아래, 왼쪽 대각선 아래 방향만 확인

        for (int t = 1; t <= test_case; t++) {
            int n, found = 0;
            char[][] board = new char[25][25];
            n = scanner.nextInt();
            Queue<Qnum> q = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                String row = scanner.next();
                for (int j = 0; j < n; j++) {
                    board[i][j] = row.charAt(j);
                    if (board[i][j] == 'o') {
                        for (int k = 0; k < 4; k++) { // 4방향만 확인
                            q.add(new Qnum(i, j, k, 1));
                        }
                    }
                }
            }

            while (!q.isEmpty()) {
                Qnum current = q.poll();

                if (current.counter >= 5) {
                    found = 1;
                    break;
                }
                int newx = current.x + dx[current.direction];
                int newy = current.y + dy[current.direction];
                if (newx >= 0 && newx < n && newy >= 0 && newy < n && board[newx][newy] == 'o') {
                    q.add(new Qnum(newx, newy, current.direction, current.counter + 1));
                }
            }
            System.out.print("#" + t + " ");
            if (found == 0) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
        scanner.close();
    }
}