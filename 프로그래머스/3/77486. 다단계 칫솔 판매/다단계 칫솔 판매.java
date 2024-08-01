// 트리 밑에서 부터 읽어오면 되는 구조 같은디
// 순회 순서만 잘 해주면 될 듯
import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, Integer> profitMap = new HashMap<>();  // 판매원별 총 이익을 저장할 맵
        Map<String, String> referralMap = new HashMap<>(); // 판매원별 추천인을 저장할 맵

        // 각 판매원에 대해 추천인 정보와 이익 초기화
        for (int i = 0; i < enroll.length; i++) {
            referralMap.put(enroll[i], referral[i]);
            profitMap.put(enroll[i], 0);
        }

        // 판매 기록 처리
        for (int i = 0; i < seller.length; i++) {
            String currentSeller = seller[i];
            int salesProfit = amount[i] * 100;  // 판매로 인한 총 이익 계산

            distributeProfit(profitMap, referralMap, currentSeller, salesProfit);
        }

        // 최종 이익을 결과 배열에 저장
        int[] answer = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = profitMap.get(enroll[i]);
        }

        return answer;
    }

    // 이익을 분배하는 함수
    private void distributeProfit(Map<String, Integer> profitMap, Map<String, String> referralMap, String seller, int profit) {
        if (seller.equals("-")) {
            return; // 추천인이 없는 경우
        }

        int commission = profit / 10;  // 추천인에게 줄 커미션 (10%)
        int remainingProfit = profit - commission;  // 판매원이 가질 이익

        profitMap.put(seller, profitMap.getOrDefault(seller, 0) + remainingProfit); // 현재 판매원의 이익 갱신

        // 추천인에게 커미션 분배
        String referrer = referralMap.get(seller);
        if (referrer != null && !referrer.equals("-") && commission > 0) {
            distributeProfit(profitMap, referralMap, referrer, commission);
        }
    }
}