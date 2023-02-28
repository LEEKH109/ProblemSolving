function solution(array) {
    //정렬을 먼저 하자
  for (let i = 1; i < array.length; i++) {
    let cur = array[i];
    let left = i - 1;
 
    while (left >= 0 && array[left] > cur) {
      array[left + 1] = array[left];
      array[left] = cur;
      cur = array[left];
      left--;
    }
  }
    let middle = Math.floor(array.length/2);
    let answer = array[middle];
    return answer;
  
}