// function solution(r1, r2) {
// 	let count = 0;
// 	//0<= <90 까지만 구하고 4배 하면 된다.
// 	//r1^2<=x^2+y^2<=r2^2 이면 count+=1;
// 	for (let i = 0; i <= r2; i++) {
// 		for (let j = 1; j <= r2; j++) {
// 			if (r1 * r1 <= i * i + j * j && i * i + j * j <= r2 * r2) {
// 				count += 1;
// 			}
// 		}
// 	}
// 	return 4 * count;
// }
// function solution(r1, r2) {
// 	let count = 0;
// 	//0<= <90 까지만 구하고 4배 하면 된다.
// 	//r1^2<=x^2+y^2<=r2^2 이면 count+=1;
// 	for (let x = 1; x <= r2; x++) {
// 		for (let y = 0; y <= Math.sqrt(r2 * r2 - x * x); y++) {
// 			if (r1 * r1 <= x * x + y * y && x * x + y * y <= r2 * r2) {
// 				count += 1;
// 			}
// 		}
// 	}
// 	return 4 * count;
// // }
function solution(r1, r2) {
	let count = 0;
	let arr = [];
	//0<= <90 까지만 구하고 4배 하면 된다.
	//r1^2<=x^2+y^2<=r2^2 이면 count+=1;
	for (let x = 1; x <= r2; x++) {
		let yCount = 0;
		if (r1 * r1 > x * x) {
			yCount = Math.floor(Math.sqrt(r2 * r2 - x * x)) - Math.ceil(Math.sqrt(r1 * r1 - x * x)) + 1;
		} else {
			Math.floor(Math.sqrt(r2 * r2 - x * x)) - Math.ceil(Math.sqrt(x * x - r1 * r1)) + 1;
		}
		count += yCount;
		arr.push(yCount);
	}
	return arr;
}

console.log(solution(2, 3)); // 20
console.log(solution(10, 15)); // 404
console.log(solution(15, 35)); // 3156
console.log(solution(11, 202)); // 127780
// console.log(solution(101, 108)); // 4620
// console.log(solution(8888, 9999)); //65921296
// console.log(solution(88888, 99999)); // 6593333640
