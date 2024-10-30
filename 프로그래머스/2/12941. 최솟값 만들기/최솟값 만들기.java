import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A); // A 배열 오름차순 정렬
        Arrays.sort(B); // B 배열 오름차순 정렬

        // B 배열 내림차순으로 뒤집기
        for (int i = 0; i < B.length / 2; i++) {
            int temp = B[i];
            B[i] = B[B.length - 1 - i];
            B[B.length - 1 - i] = temp;
        }

        int answer = 0;
        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[i];
        }
        return answer;
    }
}