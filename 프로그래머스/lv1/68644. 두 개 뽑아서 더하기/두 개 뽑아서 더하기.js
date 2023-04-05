function solution(numbers) {
    let numSet = new Set();
    let max = numbers.length
    for(let i=0; i<max; i++){
        for(let j=i+1; j<max; j++){
            numSet.add(numbers[i]+numbers[j]);
        }
    }
    return Array.from(numSet).sort((a,b)=>a-b);
}