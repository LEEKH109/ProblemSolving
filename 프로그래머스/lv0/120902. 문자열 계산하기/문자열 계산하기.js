function solution(my_string) {
//     내 풀이
//     let arr = my_string.split(' ');
//     let result = parseInt(arr[0]);
  
//     for (let i = 1; i < arr.length; i += 2) {
//         let operator = arr[i];
//         let rightNum = parseInt(arr[i + 1]);
//         operator === '+' ? result += rightNum : result -= rightNum
//     }
//     return result;
//     스택을 이용한 풀이
    const stack = [];

    let sign = 1;
    for (const ch of my_string.split(" ")) {
        if (ch === "+") {
            sign = 1;
        } else if (ch === "-") {
            sign = -1;
        } else {
            stack.push(ch * sign);
        }
    }

    return stack.reduce((a,b) => a + b, 0);
}