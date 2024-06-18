function solution(n, works) {
    // works 배열을 내림차순으로 정렬
    works.sort((a, b) => b - a);
    // 엣지케이스)works 원소의 전체 합이 n보다 작으면 결과는 0
    const totalWork = works.reduce((acc, work) => acc + work, 0);
    if (totalWork <= n) return 0;
    // max 변수는 최대 작업량을 나타냄
    let max = works[0];
    while (n > 0) {
        for (let i = 0; i < works.length; i++) {
            if (works[i] >= max && n > 0) {
                works[i]--;
                n--;
            } else {
                break;
            }
        }
        // 최댓값 다시 갱신 해주기
        max = works[0];
    }
    // 남은 작업량의 제곱의 합 계산
    return works.reduce((acc, work) => acc + work * work, 0);
}