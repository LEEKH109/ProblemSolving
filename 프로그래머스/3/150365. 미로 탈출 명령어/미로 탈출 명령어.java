import java.util.*;
class Solution {
    private static final int[] dx = {1, 0, 0, -1}; // 다운, 왼쪽, 오른쪽, 업
    private static final int[] dy = {0, -1, 1, 0};
    private static final char[] dirChars = {'d', 'l', 'r', 'u'};
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        if (!isValidStart(x, y, r, c, k)) {
            return "impossible";
        }

        Stack<PathState> stack = new Stack<>();
        stack.push(new PathState(x, y, "", k));
        boolean[][][] visited = new boolean[n+1][m+1][k+1]; // 방문 상태를 저장
        visited[x][y][k] = true;

        while (!stack.isEmpty()) {
            PathState current = stack.pop();

            if (current.remainingSteps == 0) {
                if (current.x == r && current.y == c) {
                    return current.path;
                }
                continue;
            }

            for (int i = 3; i >= 0; i--) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                int remaining = current.remainingSteps - 1;

                if (nx >= 1 && nx <= n && ny >= 1 && ny <= m && !visited[nx][ny][remaining]) {
                    visited[nx][ny][remaining] = true;
                    stack.push(new PathState(nx, ny, current.path + dirChars[i], remaining));
                }
            }
        }

        return "impossible";
    }

    private boolean isValidStart(int x, int y, int r, int c, int k) {
        int manhattan = Math.abs(r - x) + Math.abs(c - y);
        return manhattan <= k && (k - manhattan) % 2 == 0;
    }

    static class PathState {
        int x, y, remainingSteps;
        String path;

        PathState(int x, int y, String path, int remainingSteps) {
            this.x = x;
            this.y = y;
            this.path = path;
            this.remainingSteps = remainingSteps;
        }
    }
}