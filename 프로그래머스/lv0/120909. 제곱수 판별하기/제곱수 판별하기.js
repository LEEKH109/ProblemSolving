function solution(n) {
    // 첫 번째 풀이
    // let answer = 2;
    // for(i=1;i<n;i++){
    //    if(n === i*i) answer = 1
    // }
    // return answer
    // 두 번째 풀이
     return Math.sqrt(n) === parseInt(Math.sqrt(n)) ? 1 : 2
}