function solution(my_string) {
    // 첫 번째 풀이
    // return my_string.split('').filter((el1,el2)=>my_string.indexOf(el1) === el2).join('');
    // 두 번째 풀이   
    return [...new Set(my_string)].join('');
}