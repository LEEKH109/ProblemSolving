function solution(rsp) {
    // 첫 번째 풀이 => 기초적인 방법
    // var answer = '';
    // for(el of rsp){
    //     if(el === '0') answer+='5'
    //     if(el === '2') answer+='0'
    //     if(el === '5') answer+='2'
    // }
    // return answer;
    // 두번째 풀이
    let rule = {'2':'0','0':'5','5':'2'}
    let answer = ''
    for(el of rsp){
        answer+=rule[el]
    }
    return answer
}