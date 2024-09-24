import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        Map<String, Integer> PosCount = new HashMap<>();// 로봇 수 카운트
        Map<Integer, int[]> pointMap = new HashMap<>();// 포인트 번호, 좌표 매핑
        for (int i = 0; i < points.length; i++) {
            pointMap.put(i + 1, points[i]);
        }
        // 이동처리
        for (int i = 0; i < routes.length; i++) {
            move(pointMap, routes[i], PosCount);
        }
        // 위험 상황 계산
        for (int count : PosCount.values()) {
            if (count >= 2) answer += 1; 
        }
        return answer;
    }
    
    private void move(Map<Integer, int[]> pointMap, int[] route, Map<String, Integer> PosCount) {
        int time = 0;
        int[] currentPos = pointMap.get(route[0]).clone();
        recordPos(time, currentPos, PosCount);// 시작, 시간0
        for (int i = 1; i < route.length; i++) {
            int[] nextPos = pointMap.get(route[i]);
            //r 좌표 먼저 이동
            while (currentPos[0] != nextPos[0]) {
                if (currentPos[0] < nextPos[0]) {
                    currentPos[0]++;
                } else {
                    currentPos[0]--;
                }
                time++;
                recordPos(time, currentPos, PosCount);
            }
            //c 좌표 이동
            while (currentPos[1] != nextPos[1]) {
                if (currentPos[1] < nextPos[1]) {
                    currentPos[1]++;
                } else {
                    currentPos[1]--;
                }
                time++;
                recordPos(time, currentPos, PosCount);
            }
            // 마지막 포인트 정지
        }
    }
    // key 값 처리
    private void recordPos(int time, int[] Pos, Map<String, Integer> PosCount) {
        String key = time + "_" + Pos[0] + "_" + Pos[1];
        PosCount.put(key, PosCount.getOrDefault(key, 0) + 1);
    }
}