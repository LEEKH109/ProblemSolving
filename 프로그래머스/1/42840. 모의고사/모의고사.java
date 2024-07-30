import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        // 그냥 입력 배열이랑 같은 길이만큼 각각의 규칙에 맞는 배열을 만들어주면 되지 않을까?
        int length = answers.length;
        int[] pattern1 = {1,2,3,4,5};
        int[] pattern2 = {2,1,2,3,2,4,2,5};
        int[] pattern3 = {3,3,1,1,2,2,4,4,5,5};
        int[] supoja1 = getArr(length, pattern1);
        int[] supoja2 = getArr(length, pattern2);
        int[] supoja3 = getArr(length, pattern3);
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        for (int i = 0; i < length; i++) {
            if (answers[i] == supoja1[i]) count1++;
            if (answers[i] == supoja2[i]) count2++;
            if (answers[i] == supoja3[i]) count3++;
        }
        
        // 최다 득점자 찾기
        int maxScore = Math.max(count1, Math.max(count2, count3));
        
        List<Integer> result = new ArrayList<>();
        if (count1 == maxScore) result.add(1);
        if (count2 == maxScore) result.add(2);
        if (count3 == maxScore) result.add(3);
        
        // 결과를 배열로 변환하여 반환
        return result.stream().mapToInt(i -> i).toArray();
    }
    
    public static int[] getArr(int length, int[] pattern){
        int[] answers = new int[length];
        for(int i = 0; i < length; i++){
            answers[i] = pattern[i%pattern.length];
        }
        return answers;
    }
}