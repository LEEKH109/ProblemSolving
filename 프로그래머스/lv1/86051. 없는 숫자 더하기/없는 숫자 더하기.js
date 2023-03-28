function solution(numbers) {
    // 완전한 베열에서 필터링 하는 방식으로
    let fullArr =[0,1,2,3,4,5,6,7,8,9];
    return fullArr.filter(el => !numbers.includes(el)).reduce((a,b)=>a+b,0);
}