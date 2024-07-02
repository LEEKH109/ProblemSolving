// 마지막 비트 2개를 잡고 패턴을 보면
// ~10 -> ~11 로 변환
// ~01 -> ~10 로 변환 왜 11이 아닌가? 값이 제이 작아야 하므로
// ~00 -> ~01 로 변환
// ~11 -> 이게 문제인데 이 경우에는 11을 잘라내고 다시 시작한다.
// 마지막 조건으로 인한 탈출 조건
// ex) 11111111(2^8-1) 이 경우는 어떻게 할거냐? => 111111111(2^9-1)
 class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long num = numbers[i];

            if (num % 2 == 0) {
                answer[i] = num + 1;
            } else {
                String numTo2 = Long.toBinaryString(num);
                if (numTo2.contains("0")) {
                    int idx = numTo2.lastIndexOf("0");
                    numTo2 = numTo2.substring(0, idx) + "10" + numTo2.substring(idx + 2);
                } else {
                    numTo2 = "10" + numTo2.substring(1);
                }
                answer[i] = Long.parseLong(numTo2, 2);
            }
        }

        return answer;
    }
}