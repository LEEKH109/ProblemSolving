class Solution {
    public long solution(int[] sequence) {
        int n = sequence.length;
        long[] plus = new long[n];
        long[] minus = new long[n];

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                plus[i] = sequence[i] * 1L;
                minus[i] = sequence[i] * -1L;
            } else {
                plus[i] = sequence[i] * -1L;
                minus[i] = sequence[i] * 1L;
            }
        }

        long maxPlus = kadane(plus);
        long maxMinus = kadane(minus);

        return Math.max(maxPlus, maxMinus);
    }

    private long kadane(long[] array) {
        long maxSum = array[0];
        long currentSum = array[0];

        for (int i = 1; i < array.length; i++) {
            currentSum = Math.max(array[i], currentSum + array[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}