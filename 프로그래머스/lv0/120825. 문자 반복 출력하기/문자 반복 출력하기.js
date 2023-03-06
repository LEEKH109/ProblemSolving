function solution(my_string, n) {
    var answer = '';
    for(el of my_string){
        answer+=el.repeat(n)
    }
    return answer;
}