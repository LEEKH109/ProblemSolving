function solution(a, b) {
    let answer = 0;
    a>b? (x=b,y=a):(x=a,y=b);
    for(i=x;i<y+1;i++){
        answer+=i;
    }
    return answer;
}