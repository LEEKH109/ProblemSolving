function solution(numbers, k) {
    // 첫 번째 풀이
    // let result = (2*k-1) % numbers.length
    // if(result === 0) result = numbers[numbers.length-1]
    // return result
    // 두 번째 풀이
     return numbers[((2 * (k -1))) % numbers.length];
}