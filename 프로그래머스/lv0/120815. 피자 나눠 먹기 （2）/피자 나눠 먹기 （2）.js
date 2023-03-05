function solution(n) {
    let count = 1;
    //while 문을 사용해서 특정 조건을 만족할때까지 반복
    //딱 나누어 떨어진다면 count*6을 n으로 나누었을 때 나머지가 0이어야 한다.
    while((count*6)%n !== 0)
        {count = count+1;}
    return count;
}