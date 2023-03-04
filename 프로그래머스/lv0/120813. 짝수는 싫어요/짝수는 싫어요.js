function solution(n) {
    let max = Math.floor(n/2);
    let answer = [];
    for(i=0; i<=max ; i++){
        let el =2*i+1;
        if(el <= n){
        answer.push(el);
        }
    }
    return answer;
}