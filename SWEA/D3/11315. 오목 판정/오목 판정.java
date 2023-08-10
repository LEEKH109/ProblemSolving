import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int test_case = 1; test_case <= tc; test_case++) {
            int arr_size = Integer.parseInt(br.readLine());
            char[][] omokBoard = new char[arr_size][];
            for (int x = 0; x < arr_size; x++) {
                omokBoard[x] = br.readLine().toCharArray();
            }
            int[] dx = {1, 1, 1, 0};
            int[] dy = {1, 0, -1, 1};
            boolean result = false;
            find: for (int y = 0; y < arr_size; y++) {
                for (int x = 0; x < arr_size; x++) {
                    if (omokBoard[x][y] != 'o') continue;
                    for (int dir = 0; dir < 4; dir++) {
                        int cnt = 0;
                        for (int k = -2; k <= 2; k++) {
                            int nx = x + k * dx[dir], ny = y + k * dy[dir];
                            if (nx < 0 || nx >= arr_size || ny < 0 || ny >= arr_size) {
                                break;
                            }
                            if (omokBoard[nx][ny] == '.') {
                                break;
                            }
                            cnt++;
                        }
                        if (cnt == 5) {
                            result = true;
                            break find;
                        }
                    }
                }
            }
            sb.append("#").append(test_case).append(" ").append(result ? "YES" : "NO").append("\n");
        }
        System.out.print(sb.toString());
        br.close();
    }
}