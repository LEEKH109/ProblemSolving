function solution(n) {
    // 간단하게 푸는 방법
    return n%2 === 1 ? '수박'.repeat(parseInt(n/2))+'수' : '수박'.repeat(n/2)
    // 확장성 있게 푸는 방법
    // let answer =''
    // for(i=1;i<=n;i++){
    //     i%2 ? answer+='수' : answer+='박'
    // }
    // return answer
}