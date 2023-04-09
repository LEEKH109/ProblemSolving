function solution(n) {
    // 점화식으로 풀어야 될 것 같은 문제
    //1칸 까지의 방법 A1 = 1
    //2칸 까지의 방법 => A1에서 한칸 더 가기 + 처음부터 2칸 가기 => A2= A1 + 1 = 2
    //A3 = A2 + A1 = 3
    //A4 = A3 + A2 = 5
    //An = An-1 + An-2 로 정리
    let arrA = Array(n).fill(1);
    arrA[1] = 2;
    for(i=2;i<n;i++){
        arrA[i] = (arrA[i-1]+arrA[i-2])%1234567
    }
    return arrA[n-1];
}