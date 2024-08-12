class Solution {
    public int solution(int[] sticker) {
        if (sticker.length == 1) return sticker[0];
        if (sticker.length == 2) return Math.max(sticker[0], sticker[1]);

        return Math.max(rob(sticker, 0, sticker.length - 2), rob(sticker, 1, sticker.length - 1));
    }

    private int rob(int[] sticker, int start, int end) {
        if (start == end) return sticker[start];
        
        int twoBack = sticker[start];
        int oneBack = Math.max(sticker[start], sticker[start + 1]);

        for (int i = start + 2; i <= end; i++) {
            int current = Math.max(oneBack, twoBack + sticker[i]);
            twoBack = oneBack;
            oneBack = current;
        }

        return oneBack;
    }
}