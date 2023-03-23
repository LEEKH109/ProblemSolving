function solution(my_string) {
    return my_string.match(/\d/g).map(el => Number(el)).sort((a,b)=>a-b)
}