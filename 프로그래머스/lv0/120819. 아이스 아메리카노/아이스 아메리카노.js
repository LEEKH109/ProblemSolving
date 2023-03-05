function solution(money) {
    let answer = [];
    answer.push(parseInt(money/5500));
    answer.push(parseInt(money%5500))
    return answer;
}