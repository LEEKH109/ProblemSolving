function solution(num, total) {
    // num이 홀수 일때와 짝수 일때로 구분해서 풀기
    let answer = [];
       let first = num%2 !== 0 ? parseInt(total/num)-parseInt(num/2) : parseInt(total/num)+1-parseInt(num/2);
        for(i=first;i<first+num;i++){
            answer.push(i)
        }
    return answer;
}