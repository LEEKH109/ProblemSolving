function solution(babbling) {
    let newArr = babbling.map(el=> el.replaceAll(/(aya|ye|woo|ma)/gi, ""))
    return newArr.reduce((acc,idx) => acc+=(idx === '' ? 1 : 0), 0); 
}