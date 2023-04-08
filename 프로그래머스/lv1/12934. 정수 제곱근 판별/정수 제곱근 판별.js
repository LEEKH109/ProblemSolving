function solution(n) {
    // 첫 번째 풀이
    // let strNum = Math.sqrt(n).toString().split('.');
    // return strNum.length === 1 ? Math.pow(Math.sqrt(n)+1,2) : -1;
    // 두 번째 풀이
    let root = Math.sqrt(n);
    let result = (root%1 === 0 ? (root+1)*(root+1) : -1);
    return result;
    
}