function solution(before, after) {
    let Before = before.split('').sort().reduce((a,b)=>a+b,'');
    let After = after.split('').sort().reduce((a,b)=>a+b,'');
    return Before === After ? 1 : 0;
}