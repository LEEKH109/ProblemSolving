function solution(numbers) {
    let answer = 0;
    for(let i in numbers)
        {answer = answer + numbers[i]};
    result = answer/numbers.length 
    return result;
}