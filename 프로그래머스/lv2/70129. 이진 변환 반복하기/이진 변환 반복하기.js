function solution(s) {
    // 처음 풀이
    // let countWork = 0;
    // let countZero = 0;
    // let string = s;
    // function work(string){
    //     let noZero = string.split('').filter(el => el !== '0').reduce((a,b)=>a+b)
    //     countWork += 1
    //     countZero += (string.length-noZero.length)
    //     return noZero.length.toString(2)
    // }
    // while(string !== '1'){
    //     string = work(string)
    // }
    // return [countWork, countZero]
    // 개선된 풀이
    let result =[0,0];
    function work(string){
        let noZero = string.split('').filter(el => el !== '0').reduce((a,b)=>a+b)
        result[0] += 1
        result[1] += (string.length-noZero.length)
        return noZero.length.toString(2)
    }
    while(s !== '1'){
        s = work(s)
    }
    return result
}