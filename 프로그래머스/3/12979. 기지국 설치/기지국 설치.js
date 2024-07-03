function solution(n, stations, W) {
    let newStations = 0;
    let coverage = 2 * W + 1;
    let start = 1;

    for (let i = 0; i < stations.length; i++) {
        let station = stations[i];
        let leftEdge = station - W;
        // 스킵할 수 있는 커버된 영역을 계산합니다.
        if (start < leftEdge) {
            // 계산된 커버되지 않은 구간
            let uncovered = leftEdge - start;
            // 필요한 기지국의 수를 계산
            newStations += Math.ceil(uncovered / coverage);
        }
        // 다음 커버 시작점을 업데이트
        start = station + W + 1;
    }

    // 마지막 기지국 이후 커버되지 않은 부분 처리
    if (start <= n) {
        let uncovered = n - start + 1;
        newStations += Math.ceil(uncovered / coverage);
    }

    return newStations;
}