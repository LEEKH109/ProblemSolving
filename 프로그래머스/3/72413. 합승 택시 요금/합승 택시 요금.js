function solution(n, s, a, b, fares) {
    // 각 지점 간의 최대 가능 비용보다 큰 값으로 초기화
    const MAX_COST = 100000 * (n - 1) + 1;
    const dist = Array.from({ length: n + 1 }, () => Array(n + 1).fill(MAX_COST));

    // 자기 자신으로의 거리는 0으로 초기화
    for (let i = 1; i <= n; i++) {
        dist[i][i] = 0;
    }

    // 요금 정보를 이용하여 거리 행렬 초기화
    fares.forEach(([c, d, f]) => {
        dist[c][d] = f;
        dist[d][c] = f;
    });

    // 플로이드-워셜 알고리즘을 이용해 모든 지점 쌍의 최단 거리 계산
    for (let k = 1; k <= n; k++) {
        for (let i = 1; i <= n; i++) {
            for (let j = 1; j <= n; j++) {
                if (dist[i][j] > dist[i][k] + dist[k][j]) {
                    dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
    }

    // 모든 가능한 합승 지점 t를 순회하면서 최소 요금 계산
    let answer = MAX_COST;
    for (let t = 1; t <= n; t++) {
        let currentCost = dist[s][t] + dist[t][a] + dist[t][b];
        if (currentCost < answer) {
            answer = currentCost;
        }
    }

    return answer;
}