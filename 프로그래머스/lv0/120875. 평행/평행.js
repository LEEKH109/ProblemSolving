function solution(dots) {
    // 첫 번째 풀이 => 기울기를 이용한 노가다
    let answer = 0;
    {
    let test1 = Math.abs(dots[0][1]-dots[1][1]) / Math.abs(dots[0][0]-dots[1][0])
    let test2 = Math.abs(dots[2][1]-dots[3][1]) / Math.abs(dots[2][0]-dots[3][0])
    test1 === test2 ? answer+=1 : '';
    }
    {
    let test1 = Math.abs(dots[0][1]-dots[2][1]) / Math.abs(dots[0][0]-dots[2][0])
    let test2 = Math.abs(dots[1][1]-dots[3][1]) / Math.abs(dots[1][0]-dots[3][0])
    test1 === test2 ? answer+=1 : '';
    }
    {
    let test1 = Math.abs(dots[0][1]-dots[3][1]) / Math.abs(dots[0][0]-dots[3][0])
    let test2 = Math.abs(dots[1][1]-dots[2][1]) / Math.abs(dots[1][0]-dots[2][0])
    test1 === test2 ? answer+=1 : '';
    }
    return answer === 0 ? 0 : 1;
    // 두번째 반복문을 이용한 풀이 => 12 번 부터 안 풀림
    // let incilation = [];
    // let result = 0;
    // for(i=0; i<dots.length; i++){
    //     for(j=i+1; j<dots.length; j++){
    //         let lean = (dots[i][1]-dots[j][1]) / (dots[i][0]-dots[j][0]);
    //         incilation.includes(lean) ? result = 1 : incilation.push(lean);
    //     }
    // }
    // return result 
}