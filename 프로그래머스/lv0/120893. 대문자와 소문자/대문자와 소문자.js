function solution(my_string) {
    let answer = '';
    for(const el of my_string.split('')){
        el.charCodeAt() > 96 ? 
            answer+=String.fromCharCode(el.charCodeAt() - 32) :
            answer+=String.fromCharCode(el.charCodeAt() + 32)
    }
    return answer;
}