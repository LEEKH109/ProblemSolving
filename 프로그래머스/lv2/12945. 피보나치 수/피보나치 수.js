function solution(n) {
    let newArr = [0,1]
    for(let i = 2; i<n+1; i++){
        let nextNum = newArr[i-1]+newArr[i-2];
       newArr.push(nextNum%1234567);
    }
    return newArr[n];
}