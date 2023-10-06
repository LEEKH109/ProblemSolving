class Solution {
    static int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        DFS(0, 0, target, numbers);
        return answer;
    }
    public static void DFS(int cnt, int sum, int target, int [] arr){
        if(cnt == arr.length){
            if(sum == target){
                answer++;
            }
            return;
        }
        DFS(cnt + 1, sum + arr[cnt], target, arr);
        DFS(cnt + 1, sum - arr[cnt], target, arr);
    }
}