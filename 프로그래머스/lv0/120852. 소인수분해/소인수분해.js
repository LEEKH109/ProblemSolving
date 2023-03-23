function solution(n) {
    let number = n;
    let count = 2;
    let answer = [];
    while(number > 1){
        if(number%count === 0){
            number = number/count;
            answer.push(count)
            count = 1;
        }
        count+=1;
    }
    return [...new Set(answer)];
}