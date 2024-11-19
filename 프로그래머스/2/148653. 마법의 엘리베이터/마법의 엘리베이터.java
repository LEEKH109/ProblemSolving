class Solution {
    public int solution(int storey) {
        int result = 0;
        
        while (storey > 0) {
            int now = storey % 10;
            int next = storey / 10;
            if (now >= 6) { 
                result += 10 - now;
                storey = next + 1;
            } else if (now == 5 && next % 10 >= 5) {// 1 올림 고려
                result += 10 - now;
                storey = next + 1;
            } else {
                result += now;
                storey = next;
            }
        }
        return result;
    }
}