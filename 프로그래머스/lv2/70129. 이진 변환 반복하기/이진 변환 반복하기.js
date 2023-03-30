function solution(s) {
    let countWork = 0;
    let countZero = 0;
    let string = s;
    function work(string){
        let noZero = string.split('').filter(el => el !== '0').reduce((a,b)=>a+b)
        countWork += 1
        countZero += (string.length-noZero.length)
        return noZero.length.toString(2)
    }
    while(string !== '1'){
        string = work(string)
    }
    return [countWork, countZero]
}