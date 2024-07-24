// 모든 지점->지점 사이의 최단거리를 다 알아야 해서 플로이드-워셜을 사용한다.
// 정답 풀이 간선 고려해서 최댓값 설정 => 그냥 지원하는 숫자 max값 넣는게 맞는듯, 이동 못한다는 의미로 큰 수를 넣는 개념이라
function solution(n, s, a, b, fares) {
    // 각 지점 간의 최대 가능 비용보다 큰 값으로 초기화
    const MAX = 100000 * (n - 1) + 1;
    //이거 아니면 그냥
    // const MAX = Infinity;
    const dist = Array.from({ length: n + 1 }, () => Array(n + 1).fill(MAX));
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
                dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
            }
        }
    }
    let answer = MAX;
    // 같이 가는 지점을 t라고 지정
    // 모든 가능한 합승 지점 t를 순회하면서 최소 요금 계산
    for (let t = 1; t <= n; t++) {
        answer = Math.min(answer, dist[s][t] + dist[t][a] + dist[t][b]);
    }
    return answer;
}