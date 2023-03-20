function solution(n) {
    var answer = 0;
    let count = 0;
    for(let i=1; i<=n ; i++){
        for(let j=1; j<=i; j++){
            if(i%j === 0){
                count+=1;
            }
        }
        if(count>2){
            answer+=1;
        }
        count = 0;
    }
    return answer;
}