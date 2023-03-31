function solution(my_string) {
  let arr = my_string.split(' ');
  let result = parseInt(arr[0]);
  
  for (let i = 1; i < arr.length; i += 2) {
    let operator = arr[i];
    let rightNum = parseInt(arr[i + 1]);
    operator === '+' ? result += rightNum : result -= rightNum
  }
  
  return result;
}