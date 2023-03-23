function solution(A, B) {
    if(A === B) return 0;
    function push(string){
        let arr = [string[string.length-1],...string.split('').slice(0,string.length-1)]
        return arr.reduce((a,b)=>a+b,'');
    } 
    let count = 0;
    let test = A;
    for(i=0;i<A.length;i++){
        if(push(test) === B){
            count+=1;
            return count;
        }else{
            count+=1
            test = push(test)
        }
        
    }
    return -1;
}