import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        Integer[] numArray = new Integer[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numArray[i] = numbers[i];
        }

        Arrays.sort(numArray, (a, b) -> {
            int ab = Integer.parseInt("" + a + b);
            int ba = Integer.parseInt("" + b + a);
            return Integer.compare(ba, ab);
        });

        if (numArray[0] == 0) {
            return "0";
        }

        StringBuilder answer = new StringBuilder();
        for (int num : numArray) {
            answer.append(num);
        }

        return answer.toString();
    }
}