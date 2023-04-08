function solution(n) {
    let strNum = Math.sqrt(n).toString().split('.')
    return strNum.length === 1 ? Math.pow(Math.sqrt(n)+1,2) : -1
    
}