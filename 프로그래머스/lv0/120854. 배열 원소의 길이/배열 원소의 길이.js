function solution(strlist) {
    // 첫 번째 풀이
    // let answer = [];
    // for(el of strlist){
    //     answer.push(el.length)
    // }
    // return answer;
    // map으로 푸는 문제라고 해서
    return strlist.map((el)=>el.length)
}