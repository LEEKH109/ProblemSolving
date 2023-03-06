function solution(arr) {
    let answer = 0;
    for(el of arr){
        answer+=el
    }
    return answer/arr.length;
}