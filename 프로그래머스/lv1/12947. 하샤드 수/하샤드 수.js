function solution(x) {
    let harshad = x.toString().split('').reduce((acc,idx)=>acc+Number(idx),0);
    return x%harshad === 0 ? true : false;
}