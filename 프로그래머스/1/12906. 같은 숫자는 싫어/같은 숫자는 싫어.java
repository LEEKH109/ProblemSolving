import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        // 스택이 비어 있다면? 배열 해당 숫자 스택에 넣어 주기
        // 스택에 숫자가 있다면? 지금 숫자와 동일한 숫자이면 continue
        // 스택에 숫자가 있는데 동일한 숫자가 아니다? 스택에 있는 숫자 꺼내주면서 answer에 넣어주고
        // 지금 숫자 다시 스택에 넣어주기
        Stack<Integer>stack = new Stack<>();
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            if(stack.isEmpty()){
                stack.push(arr[i]);
            }else if(stack.peek() == arr[i]){
                continue;
            }else if(stack.peek() != arr[i]){
                answer.add(stack.pop());
                stack.push(arr[i]);
            }
        }
        while (!stack.isEmpty()) {
            answer.add(stack.pop());
        }
        
        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }
        
        return result;
    }
}