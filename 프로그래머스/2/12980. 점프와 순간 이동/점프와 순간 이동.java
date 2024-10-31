import java.util.*;
// DP로는 못 푼다 배열이 10억이라 메모리 터진다
// N이 10억이라 순회방식도 못 한다. 나눗셈 연산으로 줄여나가야 한다.
public class Solution {
    public int solution(int n) {
        int cnt = 0;
        while(n > 0){
            if(n%2 == 1) cnt++;
            n = n/2;
        }
        return cnt;
    }
}