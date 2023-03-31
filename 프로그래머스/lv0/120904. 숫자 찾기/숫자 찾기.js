function solution(num, k) {
    let result =  `${num}`.split('').indexOf(`${k}`);
    return result === -1 ? -1 : result+1
}