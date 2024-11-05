class Solution {
    // "BBABAAABAABB" => 11
    // "BBBBAAAABA" => 12
    public int solution(String name) {
        int n = name.length();
        int cnt = 0;
        int minMove = n - 1;

        for (int i = 0; i < n; i++) {
            char tmp = name.charAt(i);
            cnt += swap(tmp);

            int idx = i + 1;
            while (idx < n && name.charAt(idx) == 'A') {
                idx++;
            }
            int moveRL = i + i + n - idx;
            int moveLR = (n - idx) + (n - idx) + i;
            int move = Math.min(moveRL, moveLR);
            minMove = Math.min(minMove, move);
        }

        cnt += minMove;
        return cnt;
    }

    public int swap(char target) {
        return Math.min(target - 'A', 'Z' - target + 1);
    }
}