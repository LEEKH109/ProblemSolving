function solution(s) {
    
    let answer = s.toLowerCase().split(' ').map(el=> el? el[0].toUpperCase()+el.substring(1) : '').join(' ')
    return answer;
}