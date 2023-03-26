function solution(array) {
    // 첫 번째 풀이 => arr.sort
    // let big = [...array].sort((a,b)=>b-a)[0];
    // 두 번째 풀이 => Math.max 쓰기
    let big = Math.max(...array)
    return [big,array.indexOf(big)];
}