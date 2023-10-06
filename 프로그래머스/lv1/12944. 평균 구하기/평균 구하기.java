class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        for(int el : arr) answer+=el;
        return answer/arr.length;
    }
}