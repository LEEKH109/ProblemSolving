public class Solution {
    // 맨해튼 거리 계산 함수
    private int calcDist(int x, int y, int r, int c) {
        return Math.abs(x - r) + Math.abs(y - c);
    }

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        // if (Math.abs(x - r) + Math.abs(y - c) > k || (k - (Math.abs(x - r) + Math.abs(y - c))) % 2 != 0) {
        //     return "impossible";
        // }
        if ((k - calcDist(x, y, r, c)) % 2 != 0 || k < calcDist(x, y, r, c)) {
            return "impossible";
        }

        StringBuilder answer = new StringBuilder();
        int move = 0;
        // 이동 우선 순위 => d l r u
        // 그러니까 전체 이동 코스에서 d랑 l을 최대한 앞에다 먼저 배치해야 한다.
        // 하단으로 최대한 댕기기
        while (x < n && (k - move) > calcDist(x, y, r, c)) {
            move++;
            x++;
            answer.append("d");
        }

        // 좌측으로 최대한 땡기기
        while (y > 1 && (k - move) > calcDist(x, y, r, c)) {
            move++;
            y--;
            answer.append("l");
        }
        // k가 남을 때 이걸로 태운다, 위치는 바뀌면 안되어서 우좌
        // Q. 왜 상하는 안되나?
        // 우좌 반복 이동
        while ((k - move) > calcDist(x, y, r, c)) {
            move += 2;
            answer.append("rl");
        }

        // 위치 조정, 남은 move는 신경 쓰지 않는다.
        if (x < r) answer.append("d".repeat(r - x));
        if (y > c) answer.append("l".repeat(y - c));
        if (y < c) answer.append("r".repeat(c - y));
        if (x > r) answer.append("u".repeat(x - r));
        return answer.toString();
    }
}