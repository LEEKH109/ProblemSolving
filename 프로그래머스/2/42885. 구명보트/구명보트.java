import java.util.*;
// 최대 2명까지라고 주어져서 쉬운 문제, 문제를 잘 읽자
class Solution {
    public int solution(int[] people, int limit) {
        int cnt = 0;
        Arrays.sort(people);
        int n = people.length, s = 0, e = n-1;
        while(s <= e){
            if(people[s] + people[e] <= limit) s++;
            e--; cnt++;
        }
        return cnt;
    }
}