class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        // 내가 푼 풀이
        // int l = Math.max(n,m);
        // int r = Math.min(n,m);
        // int a = 1;
        // while(a < l){
        //     if(l%a == 0 && r%a == 0){
        //         answer[0] = a;
        //     }
        //     a++;
        // }
        // int b = r;
        // while(true){
        //     if(b%l == 0 && b%r == 0){
        //         answer[1] = b;
        //         break;
        //     }
        //     b++;
        // }
        // 좋은 풀이
        for (int i = 1; i < n + m; i++) {
            if (n % i == 0 && m % i == 0) {
                answer[0] = i;
                answer[1] = n * m / answer[0];
            }
        }
        return answer;
    }
}