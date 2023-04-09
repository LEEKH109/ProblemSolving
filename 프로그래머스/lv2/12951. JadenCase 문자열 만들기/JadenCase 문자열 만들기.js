function solution(s) {
    // 나의 풀이
    // let answer = s.toLowerCase().split(' ').map(el=> el? el[0].toUpperCase()+el.slice(1) : '').join(' ')
    // return answer;
    // 다른 분의 풀이 => charAt을 사용해서 중복 공백 처리
    return s.split(" ").map(v => v.charAt(0).toUpperCase() + v.substring(1).toLowerCase()).join(" ");
}