function solution(numbers) {
    //가장 큰수 순서로 정렬을 해서 처리를 하면 어떨까?
    // sort 함수 입력 방식 1번
    // numbers.sort(function(a, b)  {
    //     if(a < b) return 1;
    //     if(a === b) return 0;
    //     if(a > b) return -1;
    //     });
    // sort 함수 입력 방식 2번 => 간단
    numbers.sort((a,b)=>b-a)
    return numbers[0]*numbers[1];
}