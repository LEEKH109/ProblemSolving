function solution(arr) {
    let newArr = [...arr].sort((a,b)=>a-b)
    return arr.length === 1 ? [-1] : arr.filter((el)=>el>newArr[0])
}