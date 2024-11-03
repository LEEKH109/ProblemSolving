import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        HashSet<String> set = new HashSet<>();
        set.add(words[0]);
        for(int i = 1; i < words.length; i++){
            if(set.contains(words[i]) || words[i].charAt(0) != words[i-1].charAt(words[i-1].length()-1)){
                // [번호, 차례]
                // 8번 인덱스 탱크가 불량이었다. 사람은 3명이었다.
                // 몇 번 사람이었는지 어떻게 알 수 있을까?
                // 6%3+1 = 1, 7%3+1 = 2 8%3+1 = 3
                // 즉 번호 = i%n+1;
                // 차례는 어떻게 알 수 있을까?
                // 6,7,8 번 인덱스는 3차례 이다
                // 7,8,9 번째 단어들은 3차례 라는 뜻이다
                // 7+3-1 / 3 = 3, 8+3-1 / 3 = 3, 9+3-1 /3 = 3
                // 즉 i+1+n-1 / n = i/n+1
                answer[0] = i%n+1;
                answer[1] = i/n+1;
                System.out.println(words[i]+" "+i);
                break;
            }else{
                set.add(words[i]);
            }
        }
        return answer;
    }
}