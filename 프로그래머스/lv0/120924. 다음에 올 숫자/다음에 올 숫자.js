function solution(common) {
    if(common[2] - common[1] === common[1] - common[0]){
        return common[0]+(common[1]-common[0])*(common.length)
    }else{
        return common[0]*Math.pow(common[1]/common[0], common.length)
    }
    
}