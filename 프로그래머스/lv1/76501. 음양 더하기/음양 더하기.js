function solution(absolutes, signs) { // 내장 메소드를 쓸 이유가 없어보인다.
     let result=0;
     for(let i=0;i<absolutes.length;i++){
         signs[i] ? result+=absolutes[i] : result-=absolutes[i]
        }
    return result;
}