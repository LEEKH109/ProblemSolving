function solution(citations) {
    citations.sort((a,b)=>b-a);
    for(i=1;i<=citations[0];i++){
        if(citations.filter(el=> el>i).length === i) return i
    }
    return 0;
}