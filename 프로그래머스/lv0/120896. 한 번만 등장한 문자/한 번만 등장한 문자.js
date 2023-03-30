function solution(s) {
    let result = ''
    let arr = s.split('').sort()
    for(el of arr){
      if(arr.filter(a => a===el).length === 1) result+=el; 
    }
    return result;
}