function solution(my_string) {
    let stack = '';
    let numArr = [];
    
    for(const el of my_string){
        if(el.match(/[0-9]/g)){
            stack+=el
        }else{
            stack === '' ? '': numArr.push(stack) 
            stack =''
        }
    };
    if(stack !== '') numArr.push(stack);
    
    return numArr.reduce((acc,index)=>acc+Number(index),0);
}