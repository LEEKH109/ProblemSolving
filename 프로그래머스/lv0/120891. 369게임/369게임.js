function solution(order) {
    var answer = 0;
    while(order>1){
        if(order%10 === 3||order%10 === 6||order%10 === 9){
            answer+=1
        }
        order=parseInt(order/10);
    }
    return answer;
}