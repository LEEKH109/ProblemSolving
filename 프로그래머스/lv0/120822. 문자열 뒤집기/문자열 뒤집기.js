function solution(my_string) {
    let reverse_string =[];
     for(el of my_string){
        reverse_string.unshift(el)
    }
    let answer = '';
    for(el of reverse_string){
        answer=answer+el
    }
    return answer;
}