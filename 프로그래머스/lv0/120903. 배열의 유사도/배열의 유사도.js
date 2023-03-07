function solution(s1, s2) {
    //단순하게 푸는 방법
    let count = 0;
    for(el1 of s1){
        for(el2 of s2){
            if(el1 === el2) count++
        }
    }
    return count;
}