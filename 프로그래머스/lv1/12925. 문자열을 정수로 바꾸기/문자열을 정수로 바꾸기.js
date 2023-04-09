function solution(s) {
    
    return s[0] !== '-' ? Number(s) : -Number(s.slice(1))
}