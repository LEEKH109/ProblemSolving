class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int now = 0;
        int nowHp = health; 
        int t = bandage[0]; 
        int x = bandage[1]; 
        int y = bandage[2];
        // 시작시에는 최대 체력 만큼의 체력을 가졌다고 가정
        // 초기화는 따로 기록 할 필요가 없다. 공격하면 어차피 리셋이다.
        for(int i = 0; i < attacks.length; i++){
            // 1단계. 공격 시점까지의 체력 회복
            int tmpTime = attacks[i][0] - now - 1;
            if(tmpTime >= t){
                nowHp = heal(nowHp, health, tmpTime*x+(tmpTime/t)*y);
            }else{
                nowHp = heal(nowHp, health, tmpTime*x);
            }
            // 2단계. 공격 데미지 처리(Hp 최신화)
            if(nowHp <= attacks[i][1]){
                nowHp = -1;
                break;
            }else{
                nowHp -= attacks[i][1]; // 15
            }
            // 3단계. 시간최신화
            now = attacks[i][0];
        }
        return nowHp;
    }
    
    public int heal(int nowHp, int maxHp, int plusHp){
        int tmpHp = nowHp + plusHp;
        if(tmpHp >= maxHp){
            return maxHp;
        }else{
            return tmpHp;
        }
    }
}