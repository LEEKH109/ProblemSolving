import java.util.*;

public class Solution {
    public int solution(int[][] land) {
        int n = land.length;
        int m = land[0].length;
        boolean[][] visited = new boolean[n][m];
        List<int[]> oil = new ArrayList<>();
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        // BFS로 덩어리 별 크기 범위 체크
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                    int size = 0;
                    int min = j, max = j;
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
                    oil.add(new int[] {size, min, max});// 해당 기름 덩어리 크기, 시작 및 끝 위치 저장
                }
            }
        }

        // 열별로 석유량 계산
        int[] oilAmounts = new int[m];
        for (int[] pocket : oil) {
            for (int col = pocket[1]; col <= pocket[2]; col++) {
                oilAmounts[col] += pocket[0];
            }
        }

        // 최대 석유량을 찾아 반환
        int maxOil = Arrays.stream(oilAmounts).max().getAsInt();
        return maxOil;
    }
}