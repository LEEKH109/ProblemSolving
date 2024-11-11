import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] map = new int[102][102];
        for (int[] rect : rectangle) {
            for (int y = rect[0]*2; y <= rect[2]*2; y++) {
                for (int x = rect[1]*2; x <= rect[3]*2; x++) {
                    map[y][x] = 1;
                }
            }
        }
        
        for (int[] rect : rectangle) {
            for (int y = rect[0]*2+1; y < rect[2]*2; y++) {
                for (int x = rect[1]*2+1; x < rect[3]*2; x++) {
                    map[y][x] = 0;
                }
            }
        }
       
        boolean[][] visited = new boolean[102][102];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{characterX*2, characterY*2, 0});
        visited[characterX*2][characterY*2] = true;
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            if (curr[0] == itemX*2 && curr[1] == itemY*2) {
                return curr[2] / 2;
            }
            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];
                if (nx >= 0 && nx < 102 && ny >= 0 && ny < 102) {
                    if (!visited[nx][ny] && map[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny, curr[2] + 1});
                    }
                }
            }
        }
        return 0;
    }
}