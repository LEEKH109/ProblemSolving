class Solution {
    public int solution(int[] number) {
        int answer = 0;

        for(int i=0; i<number.length; i++){
            for(int j=i+1; j<number.length; j++){
                for(int k=j+1; k<number.length; k++){
                    if(number[i]+number[j]+number[k]==0) answer++;
                }
            }
        }

        return answer;
    }
}
// class Solution {
//     static int answer;
//     public int solution(int[] number) {
//         answer = 0;
//         dfs(number, 0, 0, 0);
//         return answer;
//     }
//     public void dfs(int[] number, int index, int sum, int count){
//         if(count == 3 && sum == 0){
//             answer ++;
//         }else{
//             for(int i = index; i < number.length; i++){
//                 dfs(number, i+1, sum+number[i], count+1);
//             }
//         }
//     }
// }