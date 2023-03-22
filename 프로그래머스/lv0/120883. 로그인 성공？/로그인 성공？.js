function solution(id_pw, db) {
    for(const el of db){
        if(el[0] === id_pw[0]){
            return el[1] === id_pw[1] ? 'login' : 'wrong pw'
        }
    }
    return 'fail'
}