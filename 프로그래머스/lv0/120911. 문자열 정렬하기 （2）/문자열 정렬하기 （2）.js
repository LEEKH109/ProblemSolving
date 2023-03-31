function solution(my_string) {
    // 첫 번째 풀이
    // return my_string.split('').map(el => el.toLowerCase()).sort().reduce((acc,el)=>acc+el,'')
    // 두 번째 풀이
    return [...my_string.toLowerCase()].sort().join('')
}