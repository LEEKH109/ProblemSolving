function solution(s) {
    let newS = s.split(' ')
    var answer = 0;
    for(let i =0 ; i<newS.length ; i++){
        newS[i] === 'Z' ? answer-=Number(newS[i-1]) : answer+=Number(newS[i])
    }
    return answer;
}