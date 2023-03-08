function solution(letter) {
    let answer = '';
    let morse = { 
    '.-':'a','-...':'b','-.-.':'c','-..':'d','.':'e','..-.':'f',
    '--.':'g','....':'h','..':'i','.---':'j','-.-':'k','.-..':'l',
    '--':'m','-.':'n','---':'o','.--.':'p','--.-':'q','.-.':'r',
    '...':'s','-':'t','..-':'u','...-':'v','.--':'w','-..-':'x',
    '-.--':'y','--..':'z'
    }
    for(el1 of letter.split(" ")){
        for(el2 of Object.keys(morse)){
            if(el1 === el2) answer+=morse[el2]
        }
    } 
    return answer;
}