// class Solution {
//     public int solution(int n) {
//         int cnt = 0;
//         for(int i = 1; i <= n; i++){
//             int sum = 0;
//             for(int j = i; j <= n; j++){
//                 if(sum+j > n){
//                     break;
//                 }else if(sum+j == n){
//                     cnt++;
//                     break;
//                 }else if(sum+j < n){
//                     sum+=j;
//                 }
//             }
//         }
//         return cnt;
//     }
// }
class Solution {
    public int solution(int n) {
        int cnt = 0;
        int sum = 0;
        for(int i = 1; i <= n; i++){
            if(n-sum <= 0) break;
            sum += i;
            if((n-sum)%i == 0){
                cnt++;
            }
        }
        return cnt;
    }
}
