function solution(n, k) {
    
    const drinkService = Math.floor(n/10)
    const answer=12000*n+2000*(k-drinkService)
    return answer;
}