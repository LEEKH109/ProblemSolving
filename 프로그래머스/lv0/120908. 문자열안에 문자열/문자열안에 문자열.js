function solution(str1, str2) {
    // 첫 번째 풀이 => indexOf
    // return str1.indexOf(str2) === -1 ? 2 : 1;
    // 두 번째 풀이 => includes
    return str1.includes(str2) ? 1 : 2
}