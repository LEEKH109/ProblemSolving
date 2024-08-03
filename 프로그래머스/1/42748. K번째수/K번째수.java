import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i = 0; i < commands.length; i++){
            answer[i] = cal(array, commands[i][0], commands[i][1], commands[i][2]);
        }
        return answer;
    }
    public int cal(int[] arr, int i, int j, int k){
        int[] tmp = Arrays.copyOfRange(arr,i-1,j);
        Arrays.sort(tmp);
        return tmp[k-1];
    }
}