function solution(quiz) {
    var answer = [];
    for(const el of quiz){
        if(el.split(' ')[1] === '+'){
            Number(el.split(' ')[0])+Number(el.split(' ')[2]) === Number(el.split(' ')[4]) ? answer.push('O') : answer.push('X')
        }
        if(el.split(' ')[1] === '-'){
            Number(el.split(' ')[0])-Number(el.split(' ')[2]) === Number(el.split(' ')[4]) ? answer.push('O') : answer.push('X')
        }
    }
    return answer;
}