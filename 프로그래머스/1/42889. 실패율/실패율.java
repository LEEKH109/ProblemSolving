import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] record = new int[N + 2]; 
        for (int stage : stages) {
            if (stage <= N) {
                record[stage]++;
            }
        }
        
        double[] rate = new double[N];
        int totalPlayers = stages.length;
        int playersRemaining = totalPlayers; 
        
        for (int i = 1; i <= N; i++) {
            if (playersRemaining > 0) {
                rate[i - 1] = (double) record[i] / playersRemaining;
                playersRemaining -= record[i]; // 다음 스테이지로 넘어갈 때 남은 사용자 수 업데이트
            } else {
                rate[i - 1] = 0;
            }
        }
        
        Integer[] idx = new Integer[N]; // 스테이지 번호를 저장할 배열
        for (int i = 0; i < N; i++) {
            idx[i] = i + 1;
        }
        
        // 실패율을 기준으로 내림차순 정렬, 실패율이 같다면 스테이지 번호 오름차순
        Arrays.sort(idx, (a, b) -> {
            if (rate[b - 1] > rate[a - 1]) {
                return 1;
            } else if (rate[b - 1] < rate[a - 1]) {
                return -1;
            } else {
                return Integer.compare(a, b);
            }
        });
        
        // 결과를 int 배열로 변환하여 반환
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = idx[i];
        }
        
        return answer;
    }
}