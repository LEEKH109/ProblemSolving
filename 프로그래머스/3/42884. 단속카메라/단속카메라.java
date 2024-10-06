import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a,b) -> a[1] - b[1]);
        int cnt = 0;
        int co = -30001;
        for(int[] el : routes){
            if(co <= el[1] && co >= el[0]){
                continue;
            }else{
                co = el[1];
                cnt++;
            }
        }
        return cnt;
    }
}
// [[-20,-15], [-14,-5], [-18,-13], [-5,-3]]
// [[-20,-15], [-18,-13], [-14,-5], [-5,-3]]