// 뭔 문제지 파악 부터
// 0 - 1, 길이 1
// 1 - 11011, 길이 5
// 2 - 1101111011000001101111011, 길이 25
// 3 - 11011110110000011011110111101111011000001101111011000000000000000000000000011011110110000011011110111101111011000001101111011
// 20 - 길이 5^20 => N으로 순회만 해도 100억 초과 10초
// 패턴이 있나?
// DP 스럽다
// N3 = N2,N2,0,N2,N2
// N4 = N3,N3,0,N3,N3
class Solution {
    public int solution(int n, long l, long r) {
        return cantor(n, l - 1, r - 1);
    }

    private int cantor(int n, long l, long r) {
        if (n == 0) return (l <= 0 && 0 <= r) ? 1 : 0;

        long length = (long) Math.pow(5, n - 1);
        int count = 0;

        for (int i = 0; i < 5; i++) {
            long newL = l - i * length;
            long newR = r - i * length;
            if (newR >= 0 && newL < length) {
                if (i == 2) continue;
                else {
                    newL = Math.max(newL, 0);
                    newR = Math.min(newR, length - 1);
                    count += cantor(n - 1, newL, newR);
                }
            }
        }
        return count;
    }
}