import java.util.*;

public class Solution {
    public int solution(int[][] land) {
        int n = land.length;
        int m = land[0].length;
        boolean[][] visited = new boolean[n][m];
        int[] oilAmounts = new int[m];
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        // BFS로 덩어리 별 크기와 범위 체크하며 바로 열별 석유량 누적
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                    int min = j, max = j;
                    int size = 0;
                    
                    while (!queue.isEmpty()) {
                        int[] current = queue.poll();
                        size++;
                        min = Math.min(min, current[1]);
                        max = Math.max(max, current[1]);
                        for (int d = 0; d < 4; d++) {
                            int nx = current[0] + dx[d];
                            int ny = current[1] + dy[d];
                            if (nx >= 0 && nx < n && ny >= 0 && ny < m && land[nx][ny] == 1 && !visited[nx][ny]) {
                                queue.offer(new int[]{nx, ny});
                                visited[nx][ny] = true;
                            }
                        }
                    }
                    // BFS 완료 후 바로 oilAmounts에 석유량 추가
                    for (int col = min; col <= max; col++) {
                        oilAmounts[col] += size;
                    }
                }
            }
        }

        // 최대 석유량을 찾아 반환
        int maxOil = 0;
        for (int tmp : oilAmounts) {
            maxOil = Math.max(maxOil, tmp);
        }
        return maxOil;
    }
}