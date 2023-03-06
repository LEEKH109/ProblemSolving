function solution(arr) {
    // 첫번째 풀이
    // let answer = 0;
    // for(el of arr){
    //     answer+=el
    // }
    // return answer/arr.length;
    // 두번째 풀이
    return arr.reduce((a,b)=>a+b)/arr.length
}