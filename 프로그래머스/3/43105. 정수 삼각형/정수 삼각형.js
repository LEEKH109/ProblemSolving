function solution(triangle) {
    // 삼각형의 크기에 맞는 동일한 구조의 DP 배열 초기화
    let dp = Array.from({length: triangle.length}, (_, i) => Array(triangle[i].length).fill(0));
    // 맨 위의 값으로 초기화
    dp[0][0] = triangle[0][0];

    // 삼각형의 두 번째 줄부터 시작하여 아래로 내려가면서 계산
    for (let row = 1; row < triangle.length; row++) {
        for (let col = 0; col <= row; col++) {
            // 맨 왼쪽일 경우
            if (col === 0) {
                dp[row][col] = dp[row - 1][col] + triangle[row][col];
            } else if (col === row) {
                // 맨 오른쪽일 경우
                dp[row][col] = dp[row - 1][col - 1] + triangle[row][col];
            } else {
                // 중간에 위치할 경우
                dp[row][col] = Math.max(dp[row - 1][col - 1], dp[row - 1][col]) + triangle[row][col];
            }
        }
    }

    // 마지막 줄에서 가장 큰 값을 찾음
    return Math.max(...dp[triangle.length - 1]);
}