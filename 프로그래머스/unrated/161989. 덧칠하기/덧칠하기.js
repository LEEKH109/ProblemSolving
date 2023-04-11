// 나의 풀이 => 11번 17번이 시간초과로 안풀린다.
// function solution(n, m, section) {
//     let wall = Array(n).fill(true);
//     let count = 0;
//     for(el of section){
//         wall[el-1] = false;
//     }
//     while(wall.includes(false)){
//         let start = wall.indexOf(false);
//         wall = [...wall.slice(0,start), ...wall.slice(start,start+m).map(el => el = true), ...wall.slice(start+m)];
//         count++;
//     }
//     return count;
// }
// 시간 초과 안나는 다른 분 풀이
function solution(n, m, section) {
  let answer = 0;
  let max = 0;
  section.forEach((s) => {
    if (s > max) {
      answer++;
      max = s + m - 1;
    }
  });
  return answer;
}

