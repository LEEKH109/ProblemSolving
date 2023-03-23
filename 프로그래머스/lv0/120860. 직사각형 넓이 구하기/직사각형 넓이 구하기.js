function solution(dots) {
    // 첫 번째 풀이
    // const height = Math.abs(
    //     dots[0][0] === dots[1][0] ? dots[0][0]-dots[2][0] : dots[0][0]-dots[1][0])
    // const width = Math.abs(
    //     dots[0][1] === dots[1][1] ? dots[0][1]-dots[2][1] : dots[0][1]-dots[1][1])
    // return height*width;
    // 두 번째 풀이
    let X = []
    let Y = []
    for(i=0;i<4;i++){
        X.push(dots[i][0]);
        Y.push(dots[i][1]);
    }
    return (Math.max(...X) - Math.min(...X)) * (Math.max(...Y) - Math.min(...Y))
}