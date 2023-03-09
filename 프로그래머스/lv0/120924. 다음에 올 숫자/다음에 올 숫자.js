function solution(common) {
    // 첫 번째 풀이
    // if(common[2] - common[1] === common[1] - common[0]){
    //     return common[0]+(common[1]-common[0])*(common.length)
    // }else{
    //     return common[0]*Math.pow(common[1]/common[0], common.length)
    // }
    // 두 번째 풀이 => 마지막 요소에서 처리
    if(common[2] - common[1] === common[1] - common[0]){
        return common[common.length-1]+common[1] - common[0]
    } return common[common.length-1]*(common[1]/common[0])
}