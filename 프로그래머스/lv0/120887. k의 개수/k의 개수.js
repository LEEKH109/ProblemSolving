function solution(i, j, k) {
    let answer = 0;
    for(let good = i; good <=j; good++){
        let one = good.toString().split('').filter((el)=>el ===`${k}`).length
        answer+=one;
    }
    return answer;
}