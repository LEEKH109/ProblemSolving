function solution(sides) {
    //내림차순으로 정렬
    sides.sort((a,b)=>b-a)
    return (sides[0]<sides[1]+sides[2] ? 1 : 2)
}