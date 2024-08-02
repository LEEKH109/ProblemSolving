import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 모든 학생이 체육복을 한 벌씩 가지고 있는 것으로 초기화
        int[] clothes = new int[n];
        Arrays.fill(clothes, 1);
        
        // 도난당한 학생들의 체육복 개수를 감소
        for (int l : lost) {
            clothes[l - 1]--;
        }
        
        // 여벌 체육복을 가진 학생들의 체육복 개수를 증가
        for (int r : reserve) {
            clothes[r - 1]++;
        }
        
        // 체육복을 빌려줄 수 있는 경우를 처리
        for (int i = 0; i < n; i++) {
            // 왼쪽 학생에게 빌려줄 수 있는 경우
            if (clothes[i] == 0) {
                if (i > 0 && clothes[i - 1] == 2) {
                    clothes[i]++;
                    clothes[i - 1]--;
                } 
                // 오른쪽 학생에게 빌려줄 수 있는 경우
                else if (i < n - 1 && clothes[i + 1] == 2) {
                    clothes[i]++;
                    clothes[i + 1]--;
                }
            }
        }
        
        // 체육복이 있는 학생 수를 계산
        int count = 0;
        for (int c : clothes) {
            if (c > 0) {
                count++;
            }
        }
        
        return count;
    }
}