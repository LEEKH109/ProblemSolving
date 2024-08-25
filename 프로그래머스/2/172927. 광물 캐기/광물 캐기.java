class Solution {
    int answer;
    int[][] tool = {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
    int remainingTools; // 전체 남은 곡괭이 수를 추적

    public int solution(int[] picks, String[] minerals) {
        answer = 25 * 50 + 1;
        remainingTools = picks[0] + picks[1] + picks[2]; // 초기 곡괭이 수를 계산
        for (int i = 0; i < 3; i++) {
            if (picks[i] > 0) {
                picks[i]--;
                remainingTools--; // 곡괭이 사용
                DFS(picks, minerals, i, 0, 0);
                picks[i]++;
                remainingTools++; // 곡괭이 복원
            }
        }
        return answer;
    }

    public void DFS(int[] picks, String[] minerals, int pickIdx, int mineralIdx, int sum) {
        int cnt = 0;
        while (cnt < 5 && mineralIdx < minerals.length) {
            if (minerals[mineralIdx].equals("diamond")) {
                sum += tool[pickIdx][0];
            } else if (minerals[mineralIdx].equals("iron")) {
                sum += tool[pickIdx][1];
            } else {
                sum += tool[pickIdx][2];
            }
            cnt++;
            mineralIdx++;
        }

        if (remainingTools == 0 || mineralIdx == minerals.length) {
            answer = Math.min(answer, sum);
            return; // 더 이상 진행할 곡괭이가 없거나 광물을 모두 캘 경우 종료
        }

        for (int i = 0; i < 3; i++) {
            if (picks[i] > 0) {
                picks[i]--;
                remainingTools--; // 곡괭이 사용
                DFS(picks, minerals, i, mineralIdx, sum);
                picks[i]++;
                remainingTools++; // 곡괭이 복원
            }
        }
    }
}