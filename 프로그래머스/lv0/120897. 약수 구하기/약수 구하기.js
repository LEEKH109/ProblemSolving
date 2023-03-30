function solution(n) {
    let answer = [];
    for(let i = 1; i <= Math.sqrt(n); i++){
        if(n%i === 0){
            i === Math.sqrt(n) ? answer.push(i) : answer.push(i,n/i);
        }
    }
    return answer.sort((a,b) => a-b);
}