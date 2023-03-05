function solution(price) {
    let resultPrice=price;
    // 첫번 째 방식
    // if(price>=100000&&price<300000){
    //     return resultPirce = parseInt(0.95*price)
    // }else if(price>=300000&&price<500000){
    //    return resultPrice = parseInt(0.9*price) 
    // }else if(price>=500000){
    //     return resultPirce = parseInt(0.8*price)
    // }
    // 두번 째 방식
    if(price>=100000&&price<300000) resultPrice = parseInt(0.95*price);
    if(price>=300000&&price<500000) resultPrice = parseInt(0.9*price) ;
    if(price>=500000) resultPrice = parseInt(0.8*price) ;
    return resultPrice;
}