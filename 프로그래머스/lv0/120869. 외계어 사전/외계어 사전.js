function solution(spell, dic) {
    let filteredDic = [...dic];
    for(const el of spell){
        filteredDic = filteredDic.filter(idx => idx.includes(el))
    }
    return filteredDic.length !== 0 ? 1 : 2;
}