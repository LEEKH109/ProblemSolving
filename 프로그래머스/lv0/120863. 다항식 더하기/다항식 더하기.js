function solution(polynomial) {
    let sort = polynomial.split(' + ')
    let front = 0;
    let back = 0;
    for(const el of sort){
        if(el === 'x'){
          front+=1
        }
        if(el.includes('x')){
            let testArr = el.split('')
            testArr.pop()
            front+=Number(testArr.reduce((a,b)=>a+b,''))
        }else{
            back+=Number(el)
        }
    }
    if(front === 1 && back === 0) return 'x'
    if(front === 1 && back !== 0) return 'x + '+back;
    
    if(front === 0 && back === 0) return '';
    if(front === 0 && back !== 0) return `${back}`;
    if(front !== 0 && back === 0) return front+'x';
    if(front !== 0 && back !== 0) return front+'x + '+back;
}