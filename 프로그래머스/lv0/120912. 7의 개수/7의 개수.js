function solution(array) {
    let answer = 0;
    for(const el of array){
        answer+=el.toString().split('').filter((el) => el === '7').length
    }
    return answer;
}