// 간단한 풀이 => 이게 더 빠름
// function solution(my_string) {
//     return my_string.split('').reverse().join('');
    
// }
// 첫번째 풀이
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