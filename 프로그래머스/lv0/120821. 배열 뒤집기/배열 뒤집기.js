function solution(num_list) {
    let answer = [];
    for(el of num_list){
       answer.unshift(el) 
    }
    return answer;
}