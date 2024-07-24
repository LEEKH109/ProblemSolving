function solution(n, s, a, b, fares) {
    const dist = Array.from({ length: n + 1 }, () => []);
    fares.forEach(([c, d, f]) => {
        dist[c].push([d, f]);
        dist[d].push([c, f]);
    });
    // 여기까지는 똑같고
    const distFromS = dijkstra(n, s, dist);
    const distFromA = dijkstra(n, a, dist);
    const distFromB = dijkstra(n, b, dist);

    let answer = Infinity;
    for (let t = 1; t <= n; t++) {
        answer = Math.min(answer, distFromS[t] + distFromA[t] + distFromB[t]);
    }

    return answer;
}

function dijkstra(n, start, graph) {
    const distances = Array(n + 1).fill(Infinity);
    const visited = Array(n + 1).fill(false);
    distances[start] = 0;

    for (let i = 0; i < n; i++) {
        let u = -1;
        // 최소 거리 노드 찾기
        for (let v = 1; v <= n; v++) {
            if (!visited[v] && (u === -1 || distances[v] < distances[u])) {
                u = v;
            }
        }
        visited[u] = true; // 노드 방문 처리
        // 인접 노드 거리 갱신
        for (const [v, cost] of graph[u]) {
            if (distances[u] + cost < distances[v]) {
                distances[v] = distances[u] + cost;
            }
        }
    }
    return distances;
}