import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        int 보석종류 = new HashSet<>(Arrays.asList(gems)).size();
 
        int[] answer = new int[2];
        int length = Integer.MAX_VALUE, 시작 = 0;
               
        Map<String, Integer> map = new HashMap<>();
        
        for (int 끝 = 0; 끝 < gems.length; 끝++) {
            map.put(gems[끝], map.getOrDefault(gems[끝], 0) + 1);
 
            while (map.get(gems[시작]) > 1) {
                map.put(gems[시작], map.get(gems[시작]) - 1);
                시작++;
            }
 
            if (map.size() == 보석종류 && length > (끝 - 시작)) {
                length = 끝 - 시작;
                answer[0] = 시작 + 1;
                answer[1] = 끝 + 1;
            }
        }
 
        return answer;
    }
}