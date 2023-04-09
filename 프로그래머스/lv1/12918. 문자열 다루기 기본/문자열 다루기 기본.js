function solution(s) {
    if(s.length !== 4 && s.length !== 6) return false;
    let filtered = s.replace(/[^0-9]/g,'');
    return filtered === s ? true : false;
}