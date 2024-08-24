import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people); 
        int minIdx = 0;
        int maxIdx = people.length - 1;
        int answer = 0;
        // 정지 조건 => 교차
        while (maxIdx >= minIdx) {
            if (people[maxIdx] + people[minIdx] <= limit) {
                minIdx++;
                maxIdx--;
            } else {
                maxIdx--;
            }
            answer++;
        }
        return answer;
    }
}