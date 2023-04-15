function solution(numbers) {
    // 첫 번째 풀이
    // numbers = numbers.map( el => el.toString() );
    // numbers.sort((a, b) => Number(b + a) - Number(a + b));
    // return numbers[0] !== '0' ? numbers.join('') : '0';
    // 다른 분 풀이
    const buckets = [];

    for (const n of numbers){
        const s = String(n), l = s.length;

        let j = '';
        for (let i = 0; i < 4; i++){
            j += s[l > i ? i : i % l];
        }
        j = 9999 - j;

        buckets[j] = buckets[j] ? buckets[j] + s : s;
    }

    const ans = buckets.join``;

    return ans[0] === '0' ? '0' : ans;

}

	