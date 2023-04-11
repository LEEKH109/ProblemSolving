
function solution(n, m, section) {
    let wall = Array(n).fill(true);
    let count = 0;
    for(el of section){
        wall[el-1] = false;
    }
    while(wall.includes(false)){
        let start = wall.indexOf(false);
        wall = [...wall.slice(0,start), ...wall.slice(start,start+m).map(el => el = true), ...wall.slice(start+m)];
        count++;
    }
    return count;
}
// 시간 초과 안나는 다른 분 풀이
// function solution(n, m, section) {
//   let answer = 0;
//   let max = 0;
//   section.forEach((s) => {
//     if (s > max) {
//       answer++;
//       max = s + m - 1;
//     }
//   });
//   return answer;
// }
// 내 풀이와 비슷한 풀이
function solution(n, m, section) {
    let map = Array(n).fill(1)
    section.forEach(el=>{
        map[el-1] = 0
    })

    var answer = 0;

    for(let i=0;i<map.length;i++){
        if(map[i] === 0){
            answer++
            for(let j=i;j<i+m;j++){
                map[j] = 1 
            }
            i += m-1
        }
    }

    return answer;
}

