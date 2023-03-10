function solution(chicken) {
    // 첫 번째 플이 => 확장성 있는 풀이
    // let service = 0;
    // while(chicken > 9){
    //     service += parseInt(chicken/10)
    //     chicken = chicken%10+parseInt(chicken/10)
    // }
    // return service
    // 두 번째 풀이 => 최적화 => 재귀
    return ~~(chicken*0.1111111)
}