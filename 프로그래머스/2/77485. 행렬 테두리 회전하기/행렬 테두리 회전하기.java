class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        // 행렬 초기화
        int[][] arr = new int[rows][columns];
        int idx = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j] = idx++;
            }
        }

        // 각 쿼리에서 회전한 후의 최솟값을 저장할 배열
        int[] answer = new int[queries.length];

        // 각 회전에 대해 수행
        for (int i = 0; i < queries.length; i++) {
            answer[i] = rotate(arr, queries[i]);
        }

        return answer;
    }
    
    // 테두리 회전 함수
    public int rotate(int[][] arr, int[] query) {
        // 쿼리에서 주어진 좌표 가져오기 (x1, y1, x2, y2)
        int x1 = query[0] - 1;
        int y1 = query[1] - 1;
        int x2 = query[2] - 1;
        int y2 = query[3] - 1;

        int temp = arr[x1][y1];
        int min = temp;

        // 왼쪽 열 위로 이동
        for (int i = x1; i < x2; i++) {
            arr[i][y1] = arr[i + 1][y1];
            min = Math.min(min, arr[i][y1]);
        }

        // 하단 행 왼쪽으로 이동
        for (int i = y1; i < y2; i++) {
            arr[x2][i] = arr[x2][i + 1];
            min = Math.min(min, arr[x2][i]);
        }

        // 오른쪽 열 아래로 이동
        for (int i = x2; i > x1; i--) {
            arr[i][y2] = arr[i - 1][y2];
            min = Math.min(min, arr[i][y2]);
        }

        // 상단 행 오른쪽으로 이동
        for (int i = y2; i > y1 + 1; i--) {
            arr[x1][i] = arr[x1][i - 1];
            min = Math.min(min, arr[x1][i]);
        }

        // 저장해둔 temp 값을 제자리에 넣어줌
        arr[x1][y1 + 1] = temp;

        // 회전 후 테두리에서 최솟값 반환
        return min;
    }
}