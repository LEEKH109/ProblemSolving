function solution(numbers, num1, num2) {
    //내장 메소드로 풀어 본다면
    // return numbers.slice(num1,num2+1)
    //slice, splice메소드 없이 push로만 구현해 본다면
    let arr = []
    for(i=num1;i<=num2;i++){
        arr.push(numbers[i])
    }
    return arr
}