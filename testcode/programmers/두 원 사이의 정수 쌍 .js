function solution(r1, r2) {
	let count = 0;
	//0<= <90 까지만 구하고 4배 하면 된다.
	//r1^2<=x^2+y^2<=r2^2 이면 count+=1;
	for (let i = 0; i <= r2; i++) {
		for (let j = 1; j <= r2; j++) {
			if (r1 * r1 <= i * i + j * j && i * i + j * j <= r2 * r2) {
				count += 1;
			}
		}
	}
	return 4 * count;
}
