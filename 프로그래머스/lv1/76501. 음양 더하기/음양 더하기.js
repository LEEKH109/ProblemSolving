function solution(absolutes, signs) { // 첫 번째 풀이 => 내장 메소드를 쓸 이유가 없어보인다.
     //let result=0;
     //for(let i=0;i<absolutes.length;i++){
         //signs[i] ? result+=absolutes[i] : result-=absolutes[i]
        //}
    // 두 번째 풀이 => 내장 메소드를 사용했지만 for문보다 가독성이 떨어진다는 생각이 든다.
    let result = absolutes.reduce((acc, val, i) => acc + val * (signs[i] ? 1 : -1), 0);
    return result;
}