function solution(sides) {
    //뇌 빼고 풀기
    // sides.sort((a,b)=>a-b)
    // let result = sides[0];
    // for(i=1; i<sides[1];i++){
    //     if(i+sides[0]>sides[1]) result+=1;
    // }
    // return result
    // 제대로 풀기
    sides.sort((a,b)=>a-b)
    return 2*sides[0]-1
}