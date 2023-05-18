function solution(n) {
    // 첫 번째 풀이
    let answer = 0;
    // for(i=1;i<=n;i++){
    //     if(n%i === 0) answer+=i
    // }
    // return answer;
    // 참신했던 풀이
    let i;
    for (i = 1; i <= Math.sqrt(n); i++){
        if (!(n%i)) {
            answer += (i+n/i);
        }
    }
    i--;
    return (i === n/i) ? answer-i : answer;
    
}