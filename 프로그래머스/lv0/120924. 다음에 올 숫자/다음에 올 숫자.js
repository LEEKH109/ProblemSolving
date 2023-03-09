function solution(common) {
    // 첫 번째 풀이
    // if(common[2] - common[1] === common[1] - common[0]){
    //     return common[0]+(common[1]-common[0])*(common.length)
    // }else{
    //     return common[0]*Math.pow(common[1]/common[0], common.length)
    // }
    // 두 번째 풀이 => 마지막 요소에서 처리
    // if(common[2] - common[1] === common[1] - common[0]){
    //     return common[common.length-1]+common[1] - common[0]
    // } return common[common.length-1]*(common[1]/common[0])
    // 세 번째 풀이 => 삼항 연산자로 => 연산 속도가 차이 나는지 비교 => 가독성은 if 문 대비 많이 떨어진다
    return common[2] - common[1] === common[1] - common[0] ? common[common.length-1]+common[1] - common[0] : common[common.length-1]*(common[1]/common[0])
}