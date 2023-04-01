function solution(spell, dic) {
    // 첫 번째 풀이
    // let filteredDic = [...dic];
    // for(const el of spell){
    //     filteredDic = filteredDic.filter((idx) => (idx.includes(el)))
    // }
    // return filteredDic.length !== 0 ? 1 : 2;
    // 두 번째 풀이 => spell 이 중복되서 들어간 경우도 고려
    let filteredDic = [...dic];
    for(const el of spell){
        filteredDic = filteredDic.filter((idx) => (idx.includes(el)&&(idx.indexOf(el) === idx.lastIndexOf(el))))
    }
    return filteredDic.length !== 0 ? 1 : 2;
}