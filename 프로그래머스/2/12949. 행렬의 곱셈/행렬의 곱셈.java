class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        
        for(int i = 0; i < arr1.length; i++){
            for(int j = 0; j < arr1[0].length; j++){
                int r = arr1[i][j];
                for(int k = 0; k < arr2[0].length; k++){
                    answer[i][k] += r * arr2[j][k];
                }
            }
        }
        return answer;
    }
}