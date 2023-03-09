function solution(n) {
    let answer = 0;
    for(i=1;i<=n;i++){
        answer++
        while(answer.toString().includes('3') || answer%3 === 0){
            answer++
        }     
    }
    return answer;
}