function solution(my_string) {
    return my_string.split('').map(el => el.toLowerCase()).sort().reduce((acc,el)=>acc+el,'')
}