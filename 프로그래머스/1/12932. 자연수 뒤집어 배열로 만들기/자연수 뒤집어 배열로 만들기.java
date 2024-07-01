class Solution {
    public int[] solution(long n) {
        String number = Long.toString(n);
        String[] arr = number.split("");
        int [] answer = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            answer[i] = Integer.parseInt(arr[arr.length-i-1]); 
        }
        return answer;
    }
}