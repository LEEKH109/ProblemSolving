function solution(age) {
    // 첫 번째 풀이
    // let answer = '';
    // let string = String(age);
    // for(el of string){
    //     if(el !== undefined){
    //         if(el === '0') answer+='a'
    //         if(el === '1') answer+='b'
    //         if(el === '2') answer+='c'
    //         if(el === '3') answer+='d'
    //         if(el === '4') answer+='e'
    //         if(el === '5') answer+='f'
    //         if(el === '6') answer+='g'
    //         if(el === '7') answer+='h'
    //         if(el === '8') answer+='i'
    //         if(el === '9') answer+='j'
    //     }
    // }
    // return answer;
    // 두 번쨰 풀이
    // let rule = ['a','b','c','d','e','f','g','h','i','j']
    // let answer = '';
    // let string = String(age);
    // for(el of string){
    //     answer+=rule[el]
    // }
    // return answer
    // 다른 사람 풀이 중 괜찮았던 것
    return age.toString().split("").map((v) => "abcdefghij"[v]).join("");

}