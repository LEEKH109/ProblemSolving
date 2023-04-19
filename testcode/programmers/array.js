function test(a, b) {
	Number(b + a) > Number(a + b) ? console.log('InnerValue', b + a + '>' + a + b) : console.log('InnerValue', b + a + '<' + a + b);
	Number(b + a) > Number(a + b)
		? console.log('InnerResult', '[' + b + ',' + a + ']=>[' + b + ',' + a + ']')
		: console.log('InnerResult', '[' + b + ',' + a + ']=>[' + a + ',' + b + ']');
	return Number(b + a) - Number(a + b);
}
function solution(numbers) {
	numbers = numbers.map((el) => el.toString());
	numbers.sort((a, b) => test(a, b));
	return numbers[0] !== '0' ? numbers.join('') : '0';
}

console.log('Result', solution([3, 30, 34, 5, 9]));
