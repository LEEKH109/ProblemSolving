function solution(my_string, letter) {
    // 짧은 풀이1
    // return my_string.replaceAll(letter, "");
    // 짧은 풀이2
    return my_string.split(letter).join('')
    // 나의 풀이
    // let answer = '';
    // for(el of my_string){
    //     if(el !== letter) answer = answer+el
    // }
    // return answer;
}