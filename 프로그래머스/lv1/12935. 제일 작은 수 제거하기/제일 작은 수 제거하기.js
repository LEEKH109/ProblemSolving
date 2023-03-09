function solution(arr) {
    // 첫 번째 풀이
    // let newArr = [...arr].sort((a,b)=>a-b)
    // return arr.length === 1 ? [-1] : arr.filter((el)=>el>newArr[0])
    // 두 번째 풀이
    return arr.length === 1 ? [-1] : arr.filter((el)=>el>Math.min(...arr))
}