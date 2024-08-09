class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while(n >= a){
            int newCoke = b*(n/a);// 새로 얻은 콜라
            int remainBottle = n%a;// 정산하고 남은 콜라
            n = newCoke + remainBottle;// 남은 병 갯수 갱신
            answer += newCoke;// 새로 받은 콜라 갯수 누적
        }
        return answer;
    }
}