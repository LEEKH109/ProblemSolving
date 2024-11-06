class Solution {
    public int[] solution(int e, int[] starts) {
        int[] count = new int[e + 1];
        // 약수의 개수 계산
        for (int i = 1; i <= e; i++) {
            for (int j = i; j <= e; j += i) {
                count[j]++;
            }
        }

        // 최대 약수 개수를 가진 수를 역순으로 저장
        int[] maxNumber = new int[e + 1];
        int maxDivisors = 0;
        int numberWithMaxDivisors = e;
        for (int i = e; i >= 1; i--) {
            if (count[i] >= maxDivisors) {
                maxDivisors = count[i];
                numberWithMaxDivisors = i;
            }
            maxNumber[i] = numberWithMaxDivisors;
        }

        // 결과 생성
        int[] result = new int[starts.length];
        for (int i = 0; i < starts.length; i++) {
            int s = starts[i];
            result[i] = maxNumber[s];
        }
        return result;
    }
}