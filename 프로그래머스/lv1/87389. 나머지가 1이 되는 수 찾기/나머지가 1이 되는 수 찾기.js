function solution(n) {
    // for문 으로 간단하게 풀기
    let answer = 0;
    for(i=1;i<=n;i++){
        if(n%i === 1){
            answer = i;
            //break 가 없으면 시간이 얼마나 차이날까?
            break;
        }
    }
    return answer;
}