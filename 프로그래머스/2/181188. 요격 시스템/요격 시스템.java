import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        // 이런 입력 범위면 N으로 풀어야 하니 DP or greedy 여기서는 greedy
        // 폭격 미사일 구간을 어떻게 정렬하면 좋을지?
        Arrays.sort(targets, (a, b) -> Integer.compare(a[1], b[1]));
        // 요격 미사일을 어디에 발사해야 가장 많은 요격 미사일을 요격할 수 있을까?
        // 범위 맨끝으로 발사하는 방식으로 그리디
        int answer = 0;
        int co = 0;
        for(int[] el : targets){
            if(co > el[0] && co <= el[1]){
                continue;
            }else{
                answer++;
                co = el[1];
            }
        }
        return answer;
    }
}