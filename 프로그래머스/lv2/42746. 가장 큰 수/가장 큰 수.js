function solution(numbers) {
    numbers = numbers.map( el => el.toString() );
    numbers.sort((a, b) => Number(b + a) - Number(a + b));
    return numbers[0] !== '0' ? numbers.join('') : '0';
}

	