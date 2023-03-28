function solution(numbers) {
    // 내 풀이 =>완전한 베열에서 필터링 하는 방식으로
   // let fullArr =[0,1,2,3,4,5,6,7,8,9];
   // return fullArr.filter(el => !numbers.includes(el)).reduce((a,b)=>a+b,0);
    // 다른 분 풀이 => 전체합에서 바로 계산
    return 45 - numbers.reduce((cur, acc) => cur + acc, 0);
}