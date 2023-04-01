function solution(score) {
    // 내 풀이
    // let averageScore = score.map(el => el.reduce((a,b)=>(a+b)/2)) // 초기값을 지정하지 않으면 배열의 첫 번째 값이 초기값이 된다.
    // let sortScore = [...averageScore].sort((a,b) => b-a) // 가독성을 위해 분리했다. 평균값을 내림차순으로 정렬해서 등수를 정한다.
    // return averageScore.map(el => sortScore.indexOf(el)+1) // sortScore에서의 등수를 indexOf()+1 로 불러온다.
    // 다른 사람 풀이
    return score.map((el) => {
    return (
      score.filter((v) => (v[0] + v[1]) / 2 > (el[0] + el[1]) / 2).length + 1
    );
  });
}