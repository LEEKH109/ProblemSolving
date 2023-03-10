function solution(my_string) {
    let answer = 0;
    for(el of my_string){
        Number(el) ? answer+=Number(el) : ''
    }
    return answer;
}