function solution(arr) {
    // 첫 번째 풀이
    // let newArr = [...arr].sort((a,b)=>a-b)
    // return arr.length === 1 ? [-1] : arr.filter((el)=>el>newArr[0])
    // 두 번째 풀이
    // return arr.length === 1 ? [-1] : arr.filter((el)=>el>Math.min(...arr))
    // 세 번째 풀이 => indexOf() 사용
    arr.splice(arr.indexOf(Math.min(...arr)),1)
    return arr[0] ? arr : [-1]
}