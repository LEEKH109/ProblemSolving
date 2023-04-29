function solution(s) {
    let string = s.split('');
    string.sort((a,b)=>b.charCodeAt(0)-a.charCodeAt(0))
    return string.join('');
}