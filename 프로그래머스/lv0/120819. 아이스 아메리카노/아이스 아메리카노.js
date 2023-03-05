function solution(money) {
    // 첫 번째 방식
    // let answer = [];
    // answer.push(parseInt(money/5500));
    // answer.push(parseInt(money%5500))
    // return answer;
    // 두 번째 방식
    return [parseInt(money/5500), money%5500]
}