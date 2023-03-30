function solution(array, n) {
    // 뇌 빼고 만든 풀이
    let newArr = [...array,n].sort((a,b)=>a-b);
    if(newArr.indexOf(n) === 0) return newArr[newArr.indexOf(n)+1];
    if(newArr.indexOf(n) === newArr.length-1) return newArr[newArr.indexOf(n)-1];
    return (Math.abs(newArr[newArr.indexOf(n)-1]-n) > Math.abs(newArr[newArr.indexOf(n)+1]-n) ? newArr[newArr.indexOf(n)+1] : newArr[newArr.indexOf(n)-1])
    // 정렬을 통해 해결해 보기
    // array.sort((a,b)=>a-b)
    // array.sort((a,b)=>Math.abs(n-a)<Math.abs(n-b) ? -1 : 1)
    // return array[0]
}