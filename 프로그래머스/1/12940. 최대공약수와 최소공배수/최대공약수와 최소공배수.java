class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int l = Math.max(n,m);
        int r = Math.min(n,m);
        int a = 1;
        while(a < l){
            if(l%a == 0 && r%a == 0){
                answer[0] = a;
            }
            a++;
        }
        int b = r;
        while(true){
            if(b%l == 0 && b%r == 0){
                answer[1] = b;
                break;
            }
            b++;
        }
        return answer;
    }
}