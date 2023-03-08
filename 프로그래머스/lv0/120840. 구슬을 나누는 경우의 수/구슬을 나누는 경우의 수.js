function solution(balls, share) {
    let num = 1;
    let denom = 1;
    for(i=balls; i>(balls-share); i--){
        num*=i
    }
    for(i=share; i>=1; i--){
        denom*=i
    }
    return num/denom;
}