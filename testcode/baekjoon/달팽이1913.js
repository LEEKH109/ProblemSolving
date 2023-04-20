function snail(num, place) {
	let arr = [];
	let test = Array(num).fill(0);
	for (let i = 0; i < num; i++) {
		arr.push([...test]);
	}

	let start = (num - 1) / 2;
	arr[start][start] = 1;

	let x = start;
	let y = start;
	let value = 2;
	let step = 1;

	while (value <= num * num) {
		// Up
		for (let i = 0; i < step && value <= num * num; i++) {
			y--;
			arr[y][x] = value++;
		}

		// Right
		for (let i = 0; i < step && value <= num * num; i++) {
			x++;
			arr[y][x] = value++;
		}

		step++;

		// Down
		for (let i = 0; i < step && value <= num * num; i++) {
			y++;
			arr[y][x] = value++;
		}

		// Left
		for (let i = 0; i < step && value <= num * num; i++) {
			x--;
			arr[y][x] = value++;
		}

		step++;
	}

	for (el of arr) {
		console.log(el.join(' '));
	}
	for (let i = 0; i < num; i++) {
		for (let j = 0; j < num; j++) {
			arr[i][j] !== place ? '' : console.log(i + 1 + ' ' + j + 1);
		}
	}
}

snail(5, 12);
