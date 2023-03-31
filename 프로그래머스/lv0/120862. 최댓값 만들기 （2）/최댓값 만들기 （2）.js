function solution(numbers) {
    // first try
    // let plusArr = numbers.filter(el=> el !== 0).sort((a,b)=>b-a);
    // if(plusArr.length === 1){
    //     return plusArr[0];
    // }else if(plusArr.length === 0){
    //     return 0
    // }
    // let minusArr = numbers.filter(el=> el !== 0).sort((a,b)=>a-b);
    // let plusMax = plusArr[0]*plusArr[1];
    // let minusMax = minusArr[0]*minusArr[1];
    // return plusMax > minusMax ? plusMax : minusMax;
    // second try
    let start = numbers[0]*numbers[1];
    for(i=0;i<numbers.length;i++){
        for(j=i+1;j<numbers.length;j++){
            if(numbers[i]*numbers[j] > start) start = numbers[i]*numbers[j]
        }
    }
    return start
    
}