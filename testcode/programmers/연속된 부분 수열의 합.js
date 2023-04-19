// function solution(sequence, k) {
// 	//브루트 포스?
// 	let bench = [];
// 	for (let i = 0; i < sequence.length; i++) {
// 		for (let j = i; j <= sequence.length; j++) {
// 			sequence.slice(i, j).reduce((a, b) => a + b, 0) !== k ? '' : bench.push([i, j - 1, ...sequence.slice(i, j)]);
// 		}
// 	}
// 	bench.sort((a, b) => a.length - b.length);
// 	return [bench[0][0], bench[0][1]];
// }

function solution(sequence, k) {
	//정답이 될 수 있는 값을 담을 배열
	var answer = [];
	var sum = 0;
	var head = 0;
	for (var i = 0; i < sequence.length; i++) {
		sum += sequence[i];
		if (sum > k) {
			// 작아질때까지 앞에 값을 빼줌.
			while (sum > k) {
				sum -= sequence[head++];
			}
		}
		//같다면 리턴
		if (sum === k) {
			answer.push([head, i]);
		}
	}
	var min = sequence.length;
	var result = [];
	answer.forEach((element) => {
		if (min > element[1] - element[0]) {
			min = element[1] - element[0];
			result = [element[0], element[1]];
		}
	});
	return result;
}

console.log(solution([1, 2, 3, 4, 5], 7));
console.log(solution([1, 1, 1, 2, 3, 4, 5], 5));
console.log(solution([2, 2, 2, 2, 2], 6));
