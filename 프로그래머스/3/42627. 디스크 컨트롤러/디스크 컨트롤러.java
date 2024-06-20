import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] jobs) {
        // 요청 시간을 기준으로 작업을 정렬
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        int nowTime = 0; // 현재 시간
        boolean[] visited = new boolean[jobs.length]; // 방문 체크 배열
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); // 소요 시간이 짧은 순으로 정렬되는 우선순위 큐
        int totalWaitTime = 0; // 총 대기 시간
        int completedJobs = 0; // 완료된 작업 수
        
        while (completedJobs < jobs.length) {
            // 현재 시간 이하에 요청된 작업들을 모두 우선순위 큐에 추가
            for (int i = 0; i < jobs.length; i++) {
                if (!visited[i] && jobs[i][0] <= nowTime) {
                    pq.add(jobs[i]);
                    visited[i] = true; // 방문 처리
                }
            }
            
            if (pq.isEmpty()) {
                // 처리할 작업이 없으면 현재 시간을 다음 요청 시간으로 이동
                for (int i = 0; i < jobs.length; i++) {
                    if (!visited[i]) {
                        nowTime = jobs[i][0];
                        break;
                    }
                }
            } else {
                // 가장 짧은 작업을 처리
                int[] currentJob = pq.poll();
                nowTime += currentJob[1];
                totalWaitTime += nowTime - currentJob[0];
                completedJobs++;
            }
        }
        // 평균 대기 시간 계산 및 반환 (소수점 이하 버림)
        return totalWaitTime / jobs.length;
    }
}