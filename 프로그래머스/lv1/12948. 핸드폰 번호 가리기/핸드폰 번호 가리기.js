function solution(str) {
    // 첫 번째 풀이
    // let numLength = phone_number.length;
    // let open = phone_number.slice(numLength-4,numLength)
    // let secret = '*'.repeat(numLength-4)
    // return secret+open;
    // 두 번째 풀이=> 리팩토링
    // return '*'.repeat(str.length-4)+str.slice(-4);
    // 세번째 풀이 Array.fill이용
    // return [...str].fill("*",0,str.length-4).join("")
    // 다른 분 풀이 => 정규표현식
    return str.replace(/\d(?=\d{4})/g, "*");
}