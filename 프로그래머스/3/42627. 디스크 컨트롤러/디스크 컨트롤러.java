import java.util.Arrays;

class Solution {
    public int solution(int[][] jobs) {
        // 요청 시간을 기준으로 작업을 정렬
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        int nowTime = 0; // 현재 시간
        boolean[] visited = new boolean[jobs.length]; // 방문 체크 배열
        int totalWaitTime = 0; // 총 대기 시간
        int completedJobs = 0; // 완료된 작업 수
        
        while (completedJobs < jobs.length) {
            int shortestJobIndex = -1;
            int shortestJobTime = Integer.MAX_VALUE;
            
            // 현재 시간 이하에 요청된 작업 중 가장 짧은 작업을 찾음
            for (int i = 0; i < jobs.length; i++) {
                if (!visited[i] && jobs[i][0] <= nowTime) {
                    if (jobs[i][1] < shortestJobTime) {
                        shortestJobTime = jobs[i][1];
                        shortestJobIndex = i;
                    }
                }
            }
            
            if (shortestJobIndex == -1) {
                // 처리할 작업이 없으면 현재 시간을 다음 요청 시간으로 이동
                for (int i = 0; i < jobs.length; i++) {
                    if (!visited[i]) {
                        nowTime = jobs[i][0];
                        break;
                    }
                }
            } else {
                // 가장 짧은 작업을 처리
                visited[shortestJobIndex] = true;
                nowTime += jobs[shortestJobIndex][1];
                totalWaitTime += nowTime - jobs[shortestJobIndex][0];
                completedJobs++;
            }
        }
        
        // 평균 대기 시간 계산 및 반환 (소수점 이하 버림)
        return totalWaitTime / jobs.length;
    }
}