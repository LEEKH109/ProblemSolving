function solution(n) {
    // 첫번째 풀이
    // let pizza = Math.ceil(n/7)
    // return pizza;
    // 두번째 풀이 => Math 함수 없이
    let pizza = 0;
    (n%7 !==0) ? pizza = parseInt(n/7)+1 : pizza = parseInt(n/7)
    return pizza
}