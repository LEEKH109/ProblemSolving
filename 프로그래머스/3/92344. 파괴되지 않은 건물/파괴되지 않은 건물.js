function solution(board, skill) {
    const N = board.length;
    const M = board[0].length;
    let changes = Array.from({length: N + 1}, () => new Array(M + 1).fill(0));

    // 스킬 적용하여 차분 배열 구성
    skill.forEach(([type, r1, c1, r2, c2, degree]) => {
        if (type === 1) degree = -degree;  // 공격일 경우 내구도 감소

        changes[r1][c1] += degree;
        if (c2 + 1 < M) changes[r1][c2 + 1] -= degree;
        if (r2 + 1 < N) changes[r2 + 1][c1] -= degree;
        if (r2 + 1 < N && c2 + 1 < M) changes[r2 + 1][c2 + 1] += degree;
    });

    // 누적합을 이용하여 행 방향으로 누적
    for (let r = 0; r < N; r++) {
        for (let c = 1; c < M; c++) {
            changes[r][c] += changes[r][c - 1];
        }
    }

    // 누적합을 이용하여 열 방향으로 누적
    for (let c = 0; c < M; c++) {
        for (let r = 1; r < N; r++) {
            changes[r][c] += changes[r - 1][c];
        }
    }

    // 최종적으로 board에 changes 적용하면서 파괴되지 않은 건물 세기
    let unbrokenCount = 0;
    for (let r = 0; r < N; r++) {
        for (let c = 0; c < M; c++) {
            board[r][c] += changes[r][c];
            if (board[r][c] > 0) {
                unbrokenCount++;
            }
        }
    }

    return unbrokenCount;
}