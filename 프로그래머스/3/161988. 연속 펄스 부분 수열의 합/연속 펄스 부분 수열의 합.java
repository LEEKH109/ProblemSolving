class Solution {
    public long solution(int[] sequence) {
        int n = sequence.length;
        int[] plus = new int[n];
        int[] minus = new int[n];

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                plus[i] = sequence[i];
                minus[i] = sequence[i] * -1;
            } else {
                plus[i] = sequence[i] * -1;
                minus[i] = sequence[i];
            }
        }

        long maxPlus = sum(plus);
        long maxMinus = sum(minus);

        return Math.max(maxPlus, maxMinus);
    }

    private long sum(int[] arr) {
        long maxSum = arr[0];
        long currentSum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}