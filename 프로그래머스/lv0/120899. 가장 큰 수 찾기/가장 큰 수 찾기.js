function solution(array) {
    let big = [...array].sort((a,b)=>b-a)[0];
    return [big,array.indexOf(big)];
}