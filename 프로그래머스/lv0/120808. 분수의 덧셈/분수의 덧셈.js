function solution(numer1, denom1, numer2, denom2) {
    const resultNumer = ((numer1*denom2)+(denom1*numer2));
    const resultDenom = (denom1*denom2);
    let testNum=1;
    for(i=1;i<=resultNumer;i++){
        if(resultNumer%i === 0 && resultDenom%i === 0)
            testNum = i;
    }
    const answer = [resultNumer/testNum, resultDenom/testNum];
    return answer;
}