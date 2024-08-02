import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        if (arr.length == 0) return new int[0];  // 빈 배열 처리
        
        ArrayList<Integer> answer = new ArrayList<>();
        int pre = arr[0];
        answer.add(pre);
        
        for (int i = 1; i < arr.length; i++) {
            if (pre != arr[i]) {
                answer.add(arr[i]);
                pre = arr[i];
            }
        }
        
        // ArrayList를 int 배열로 변환
        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }
        
        return result;
    }
}