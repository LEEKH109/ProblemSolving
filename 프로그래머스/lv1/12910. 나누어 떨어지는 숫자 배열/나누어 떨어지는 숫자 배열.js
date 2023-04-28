function solution(arr, divisor) {
    
    let filteredArr = arr.filter(el=>el%divisor === 0).sort((a,b)=>a-b)
    return filteredArr.length !== 0 ? filteredArr : [-1]
}