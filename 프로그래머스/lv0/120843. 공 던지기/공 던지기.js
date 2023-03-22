function solution(numbers, k) {
    let result = (2*k-1) % numbers.length
    if(result === 0) result = numbers[numbers.length-1]
    return result
}