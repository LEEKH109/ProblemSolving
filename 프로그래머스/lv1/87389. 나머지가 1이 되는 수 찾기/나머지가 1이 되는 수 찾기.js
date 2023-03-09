function solution(n) {
    // for문 으로 간단하게 풀기
    for(i=1;i<=n;i++){
        if(n%i === 1){
           return i
        }
    }
}