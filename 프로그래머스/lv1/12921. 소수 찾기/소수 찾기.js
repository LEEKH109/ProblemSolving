function solution(n) {
    // 첫 번째 풀이 시간 복잡도 => O(n^1.5)
    // let result = 0;
    // for(i=2;i<=n;i++){
    //         let count = 0;
    //     for(j=1;j<=Math.sqrt(i);j++){
    //         if(i%j === 0) count++;
    //     }
    //     if(count === 1) result++;
    // }
    // return result;
    // 시간초과 ㅠㅡㅜ 배열로 풀기 싫었는데
    // 두 번째 풀이는 에라토스테네스의 체로 풀 예정
    let arrFrime = Array(n+1).fill(true);
    arrFrime[0] = false;
    arrFrime[1] = false;
    
    for(let i=2; i<=Math.sqrt(n); i++) {
        if(arrFrime[i]) { // i가 소수인 경우
            for(let j=i*i; j<=n; j+=i) { // i의 배수들을 모두 소수에서 제외
                arrFrime[j] = false;
            }
        }
    }
    return arrFrime.reduce((acc,idx)=> idx===true ? acc+1 : acc,0)
}