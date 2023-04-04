function solution(lines) {
    //다른 분 풀이
    let line = new Array(201).fill(0); 
    // -100부터 100까지의 범위를 포함하는 line 배열을 0으로 채움
    lines.forEach(([a, b]) => {
      for(; a < b; a++) {
        line[a+100]++;
      }
    });
    return line.reduce((a, c) =>  c > 1 ? a + 1 : a, 0)
}