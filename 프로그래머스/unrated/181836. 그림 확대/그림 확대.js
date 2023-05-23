function solution(picture, k) {
    let result = [];
    for(const el of picture){
        let mulLetter = '';
        for(const le of el){
            mulLetter += le.repeat(k)
        };
        for(i=0;i<k;i++){
            result.push(mulLetter)
        };
    }
    return result;
    //시간복잡도 O(n^2)
}