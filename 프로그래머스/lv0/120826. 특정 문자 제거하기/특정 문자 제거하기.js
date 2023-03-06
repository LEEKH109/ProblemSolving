function solution(my_string, letter) {
    let answer = '';
    for(el of my_string){
        if(el !== letter) answer = answer+el
    }
    return answer;
}