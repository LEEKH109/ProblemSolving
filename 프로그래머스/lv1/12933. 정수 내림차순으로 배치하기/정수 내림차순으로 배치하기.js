function solution(n) {
    let reverseString = n.toString().split('').sort((a,b)=>b-a).reduce((acc,idx)=>acc+idx,'')
    return Number(reverseString);
}