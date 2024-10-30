// class Solution {
//     public int solution(int n) {
//         int targetCount = Integer.bitCount(n); // n의 1의 개수를 구함
//         int answer = n + 1; // n보다 큰 수부터 탐색 시작

//         // n보다 큰 숫자 중에서 1의 개수가 같은 숫자를 찾음
//         while (Integer.bitCount(answer) != targetCount) {
//             answer++;
//         }

//         return answer;
//     }
// }
class Solution {
    public int solution(int n) {
        int smallest = n & -n;         // 가장 오른쪽 1을 찾음
        int ripple = n + smallest;     // 오른쪽의 0을 1로 변경해 다음 큰 수 패턴 생성
        int ones = n ^ ripple;         // 원래 숫자와의 XOR 연산으로 바뀐 비트 추출
        ones = (ones >> 2) / smallest; // ones를 오른쪽으로 정렬

        return ripple | ones;          // 새로운 패턴을 합쳐서 다음 큰 수 반환
    }
}