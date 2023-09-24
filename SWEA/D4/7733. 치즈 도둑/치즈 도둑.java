import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    static int[][] arr;
    static boolean[][] check;
    static int[] dx = {-1, 0, 1, 0}; // 상, 우, 하, 좌
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스의 수

        for(int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt(); // 배열의 길이
            arr = new int[N][N];
            check = new boolean[N][N];
            
            int maxDay = 0;

            for(int x = 0; x < N; x++) {
                for(int y = 0; y < N; y++) {
                    arr[x][y] = sc.nextInt();
                    maxDay = Math.max(maxDay, arr[x][y]);
                }
            }

            int maxLump = 1; // 히든 케이스 ㅠㅡㅜ

            for(int day = 1; day <= maxDay; day++) {
                int currentLump = 0;

                for(int x = 0; x < N; x++) {
                    for(int y = 0; y < N; y++) {
                        if(arr[x][y] == day) {
                            arr[x][y] = 0;
                        }
                    }
                }//해당 날짜 치즈 먹기

                check = new boolean[N][N];
                for(int x = 0; x < N; x++) {
                    for(int y = 0; y < N; y++) {
                        if(!check[x][y] && arr[x][y] != 0) {//이전 탐색시 방문한 곳 + 값이 0이어서 치즈가 남지 않은 영역은 패스
                            bfs(x, y, N, day);//일단 이게 들어가서 끝나면 한 덩어리 체크가 끝난 것
                            currentLump++;
                        }
                    }
                }
                maxLump = Math.max(maxLump, currentLump);
            }
            System.out.println("#" + tc + " " + maxLump);
        }
        sc.close();
    }
    
    public static void bfs(int x, int y, int N, int day) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        check[x][y] = true;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            for(int dir = 0; dir < 4; dir++) {
                int nx = current[0] + dx[dir];
                int ny = current[1] + dy[dir];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(!check[nx][ny] && arr[nx][ny] > day) {
                    check[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }
}