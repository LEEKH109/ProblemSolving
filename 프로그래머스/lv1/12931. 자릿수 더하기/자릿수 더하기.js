function solution(n)
{
    const str = String(n);
    const strToNum = (arg) => Number(arg);
    const newArr = Array.from(str, strToNum);
    let answer = 0;
    for(let el of newArr){
        answer=answer+el;
    }
    return answer;
}