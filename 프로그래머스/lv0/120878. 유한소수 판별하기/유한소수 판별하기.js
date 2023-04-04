function solution(a, b) {
//     나의 풀이
//     // for 반복문을 이용해서 최대공약수 구하기 => 시간복잡도 O(n)
//     let divG = 1; // 공간복잡도 O(1)
//     for(let i =1; i<=a; i++){
//         if(a%i === 0 && b%i === 0){divG = i}
//         i++
//     }
//     b /= divG;
    
//     let factors = [];
//     let divisor = 2;
//     // while 반복문으로 소인수 분해 => 시간복잡도 O(log n)
//     while (b >= 2) {
//      if (b % divisor == 0) {
//        factors.push(divisor);
//        b /= divisor;
//      } else {
//        divisor++;
//      }
//     }
//     return factors.reduce((acc, el) => {
//         return el > 5 || el === 3 ? acc+1 : acc ;
//         }, 0) === 0 ? 1 : 2;
//     다른분 풀이
    let n = 1;
    for (let i = 1; i <= Math.min(a,b); i++) {
        if (a%i===0 && b%i===0) n = i;
    }

    b/=n;
    while (b%2===0) b/=2;
    while (b%5===0) b/=5;

    return b === 1 ? 1 : 2;   
}