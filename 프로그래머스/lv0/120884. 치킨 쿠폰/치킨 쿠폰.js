function solution(chicken) {
    let service = 0;
    while(chicken > 9){
        service += parseInt(chicken/10)
        chicken = chicken%10+parseInt(chicken/10)
    }
    return service
}