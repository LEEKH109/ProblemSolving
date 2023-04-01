function solution(numlist, n) {
    // first try => success
    // return numlist.sort((a,b)=> b-a ).sort((a,b)=> Math.abs(n-a) >= Math.abs(n-b) ? 1: -1);
    // second try
     return numlist.sort((a, b) => Math.abs(a - n) - Math.abs(b - n) || b - a);
}