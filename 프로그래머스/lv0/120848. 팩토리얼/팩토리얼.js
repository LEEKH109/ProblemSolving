function solution(n) {
    if(n===1) return 1
    function fac(num){
        let result = 1;
        if(num === 1 || num === 0){
            return result;
        }else{
            for(i=1;i<=num;i++){
                result *= i;
            }
            return result;
        } 
    }
    let answer = 0;
    while(fac(answer)<n ){
        answer+=1;
        if(fac(answer)>n){ return answer-1;}
    }
    return answer;
}