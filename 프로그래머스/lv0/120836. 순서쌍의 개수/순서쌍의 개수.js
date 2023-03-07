function solution(n) {
    // 첫 번째로 생각한 풀이 반복문을 이용한 대입
    // let answer = 0;
    // for(i=1;i<=n;i++){
    //     for(j=1;j<=n;j++){
    //         if(i*j === n) answer++
    //     }
    // }
    // return answer;
    // 두 번째로 생각한 풀이 => 순서상의 갯수 === 약수의 갯수
    let divisorNum = 0;
    for(i=1;i<=n;i++){
        if(n%i === 0){
            divisorNum++
        }
    }
    return divisorNum;
}