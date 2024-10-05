import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (a, b) -> Integer.compare(a[1], b[1]));
        int answer = 0;
        double co = -1e9;
        for(int[] el : targets){
            if(co > el[0] && co < el[1]){
                continue;
            }else{
                answer++;
                co = el[1] - 0.1; // e보다 작은 값으로 설정
            }
        }
        return answer;
    }
}