// 1 ≤ s의 길이 ≤ 1,000,000
// 1 ≤ s의 각 원소 길이 ≤ 1,000,000
// 1 ≤ s의 모든 원소의 길이의 합 ≤ 1,000,000
// 음 110이 어디 있는지 찾는게 1번
// 110이 여러개 일 대도 커버가 되는게 2번   
// 110을 체크하고 전부 제거, 그리고 갯수 카운트
// 못 풀겠어서 블로그 봤어요....

import java.util.*;

class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        
        for(int i=0; i<s.length; i++){
            String ans = solve(s[i]);   
            answer[i] = ans;
        }
        
        return answer;
    }
    
    public String solve(String s){
        StringBuilder sb = new StringBuilder();// 110 제거된 문자열 담을
        int count = 0;// 110 갯수 저장 할 변수
        
        for(int i=0; i<s.length(); i++){
            Character c = s.charAt(i);
            if(sb.length()>=2 && c=='0' && sb.charAt(sb.length()-2)=='1' && sb.charAt(sb.length()-1)=='1'){
                count++;
                sb.delete(sb.length()-2, sb.length());
            }
            else{
                sb.append(c);
            }
        }
        
        if(count > 0){
            if(sb.indexOf("0")==-1){
                // '0'이 없으면 sb의 시작 부분에 "110"을 삽입
                for(int i = 0; i < count; i++) {
                    sb.insert(0, "110");
                }
            }
            else{
                // 마지막 '0' 뒤에 "110"을 삽입
                int idx = sb.lastIndexOf("0");
                for(int i = 0; i < count; i++) {
                    sb.insert(idx + 1, "110");
                }
            }
        }
        
        return sb.toString();
    }
}