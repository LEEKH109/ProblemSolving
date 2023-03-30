function solution(n) {
    // 나의 풀이
    // let answer = [];
    // for(let i = 1; i <= Math.sqrt(n); i++){
    //     if(n%i === 0){
    //         i === Math.sqrt(n) ? answer.push(i) : answer.push(i,n/i);
    //     }
    // }
    // return answer.sort((a,b) => a-b);
    // 다른 사람 풀이
    return Array(n).fill(0).map((v, index) => v+index+1).filter((v) => n%v===0);
}