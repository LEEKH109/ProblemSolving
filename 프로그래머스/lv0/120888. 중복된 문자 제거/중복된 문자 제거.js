function solution(my_string) {
    return my_string.split('').filter((el1,el2)=>my_string.indexOf(el1) === el2).join('');
}