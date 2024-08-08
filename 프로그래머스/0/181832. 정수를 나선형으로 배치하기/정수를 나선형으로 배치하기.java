class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n]; // n x n 배열 초기화
        int num = 1; // 채울 숫자, 1부터 시작
        int[] pos = {0, 0}; // 위치 배열, pos[0]은 x, pos[1]은 y
        int caseDirection = 0; // 초기 방향: 오른쪽
        int[][] moves = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 이동 방향 (오른쪽, 아래, 왼쪽, 위)

        for (int i = 0; i < n * n; i++) {
            answer[pos[0]][pos[1]] = num++; // 현재 위치에 숫자 채우기
            
            // 다음 위치 계산
            int nextX = pos[0] + moves[caseDirection][0];
            int nextY = pos[1] + moves[caseDirection][1];

            // 범위 체크 및 이미 채워진 칸 체크
            if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n || answer[nextX][nextY] != 0) {
                caseDirection = (caseDirection + 1) % 4; // 방향 전환
                nextX = pos[0] + moves[caseDirection][0];
                nextY = pos[1] + moves[caseDirection][1];
            }
            // 위치 업데이트
            pos[0] = nextX;
            pos[1] = nextY;
        }
        return answer; // 완성된 배열 반환
    }
}