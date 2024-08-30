import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        // 그냥 배열 정렬을 때리자
        Arrays.sort(score);
        int answer = 0;
        int n = score.length;
        for(int i = n-m; i >= 0; i -= m){
            answer+=score[i]*m;
        }
        return answer;
    }
}
// [1,1,1,2,2,3,3] n = 7
// m = 4
// 7-1-4 = 2