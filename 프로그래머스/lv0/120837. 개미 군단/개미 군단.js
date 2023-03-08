function solution(hp) {
    // 첫 번째 풀이
    // let antg = parseInt(hp/5)
    // let ants = parseInt((hp-5*antg)/3)
    // let antw = hp-5*antg-3*ants
    // return antg+ants+antw;
    // 두 번째 풀이
    return parseInt(hp/5)+parseInt((hp%5)/3)+(hp%5)%3;
}