// function solution(r1, r2) {
    // 1차 시도 => 테스트케이스 7번부터 시간초과
	// let count = 0;
	// //0<= <90 까지만 구하고 4배 하면 된다.
	// //r1^2<=x^2+y^2<=r2^2 이면 count+=1;
	// for (let i = 0; i <= r2; i++) {
	// 	for (let j = 1; j <= Math.sqrt(r2 * r2 - i * i); j++) {
	// 		if (r1 * r1 <= i * i + j * j && i * i + j * j <= r2 * r2) {
	// 			count += 1;
	// 		}
	// 	}
	// }
	// return 4 * count;
// }
    //2차 시도
function solution(r1, r2) {
    let answer = 0;
    
    for (let i=1; i < r2; i++) {
         if (i < r1) {
            answer += getMaxY(i, r2, "r2") - getMaxY(i, r1, "r1");
        } else {
            answer += getMaxY(i, r2, "r2");
        }
    }
    answer *= 4;
    answer += (r2 - r1 + 1) * 4;
    return answer;
}

function getMaxY(x, r, rName) {
    const max = Math.sqrt(r * r - x * x);
    const maxToInt = parseInt(max);
    if (rName == "r1" && max - maxToInt == 0.0) {
        return maxToInt - 1;
    } else {
        return maxToInt;
    }
}