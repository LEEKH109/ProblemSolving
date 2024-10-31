import java.util.*;
class Solution{
    public int solution(String s){
        char[] str = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < str.length; i++){
            if(stack.isEmpty()){
                stack.add(str[i]);
            }else{
                if(stack.peek() == str[i]){
                    stack.pop();
                    continue;
                }
                stack.add(str[i]);
            }
        }
        return stack.size() >= 1 ? 0 : 1;
    }
}