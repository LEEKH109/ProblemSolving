function solution(n) {
    // 두번째 풇이
    let answer = [];
    for(i=1;i<=n;i+=2){
        answer.push(i)
    }
    return answer;
    // 첫번째 풀이
    // let max = Math.floor(n/2);
    // let answer = [];
    // for(i=0; i<=max ; i++){
    //     let el =2*i+1;
    //     if(el <= n){
    //     answer.push(el);
    //     }
    // }
    // return answer;
}