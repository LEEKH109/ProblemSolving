function solution(numbers) {
   let numSet = [ "zero", "one", "two", "three", "four", "five",
                 "six", "seven", "eight", "nine" ];
    numSet.forEach((str, idx) => {
        numbers = numbers.replaceAll(str, idx);
    });
    return Number(numbers);
}