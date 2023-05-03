function solution(d, budget) {
    // greedy
    d.sort((a,b)=>a-b)
    let count = 0;
    while(budget>0){
        if(budget >= d[0]){
            budget-=d[0]}
        else{
            break;}
        d.splice(0,1);
        count++;
    }
    return count;
}