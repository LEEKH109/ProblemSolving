function solution(numbers) {
    //가장 큰수 순서로 정렬을 해서 처리를 하면 어떨까?
    numbers.sort(function(a, b)  {
        if(a < b) return 1;
        if(a === b) return 0;
        if(a > b) return -1;
        });
    return numbers[0]*numbers[1];
}