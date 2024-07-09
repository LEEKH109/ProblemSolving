import java.util.Stack;

class Solution {
    // private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    // 스택에서 팝 될거를 고려해서 순서를 역순 배열
    private static final int[] dx = {-1, 0, 0, 1}; // 상, 좌, 우, 하
    private static final int[] dy = {0, 1, -1, 0};
    private static final char[] dirChars = {'u', 'r', 'l', 'd'}; // 해당 방향을 문자로 매핑

    // 이동경로 관리 클래스 Path
    static class Path {
        int x, y, remainedDistance;
        String path; // 이동경로 문자열 저장

        Path(int x, int y, String path, int remainedDistance) {
            this.x = x;
            this.y = y;
            this.path = path;
            this.remainedDistance = remainedDistance;
        }
    }
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        // 맨해튼 거리 기반으로 종료지점으로 k 안에 이동 가능 여부 체크
        if (Math.abs(x - r) + Math.abs(y - c) > k || (k - (Math.abs(x - r) + Math.abs(y - c))) % 2 != 0) {
            return "impossible";
        }
        
        // 스택 기반으로 DFS 구현 을 위해 스택 선언, dfs-스택-bfs-큐
        Stack<Path> stack = new Stack<>();
        stack.push(new Path(x, y, "", k));

        while (!stack.isEmpty()) {
            Path current = stack.pop();
            
            if (current.remainedDistance == 0) {// 더 이동 못 하면
                if (current.x == r && current.y == c) {// 도착했는지 체크 하고, 도착했으면
                    return current.path;// 완성된 이동경로 문자열 반환
                    // 따로 경로 들 값 비교를 안해주는 이유는 스택에 추가되는 순서가 사전 역순으로 들어가므로
                    // 최초로 반환되는 이동경로 문자열이 사전 순으로 가장 빠른 문자열
                }
                continue;
            }
            // 도달 못 했으면 거리 -1 시키고 이제 각 방향으로 이동 시키기, 방향은 사전 순으로 가장 빠른 경로를 반환해야 하기에
            // 넣어 주는 순서가 중요
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                int remaining = current.remainedDistance - 1;
                // 유효성 검증 - 범위 안인지, 목표지점까지 갈 수 있는지 체크 후
                // DFS 진행
                // 여기서 맨해튼 거리로 백트랙킹 안하면 시간 초과 발생
                if (isValid(n, m, nx, ny) && isAbleToArrive(remaining, r, c, nx, ny)) {
                    stack.push(new Path(nx, ny, current.path + dirChars[i], remaining));
                }
            }
        }

        return "impossible";
    }
    // 범위 벗어나는 것 방지하는 함수
    private boolean isValid(int n, int m, int x, int y) {
        return x >= 1 && x <= n && y >= 1 && y <= m;
    }
    // 맨해튼 거리 기반 도착 가능성 체크
    private boolean isAbleToArrive(int remainedDistance, int destX, int destY, int x, int y) {
        int manhattan = Math.abs(destX - x) + Math.abs(destY - y);
        return manhattan <= remainedDistance && (remainedDistance - manhattan) % 2 == 0;
    }
}