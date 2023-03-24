function solution(a, b) {
    //첫 번째 풀이
    // let answer = 0;
    // a>b? (x=b,y=a):(x=a,y=b);
    // for(i=x;i<y+1;i++){
    //     answer+=i;
    // }
    // return answer;
    // 두 번째 풀이 => 가우스 ㄷㄷ
    return (a+b) * (Math.abs(a-b)+1) / 2;
}