class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] result = new int[balls.length];
        for (int i = 0; i < balls.length; i++) {
            int endX = balls[i][0];
            int endY = balls[i][1];
            int minDist = 987654321;
            if (!(startX == endX && startY < endY)){ 
                minDist = Math.min(minDist, cal(startX, startY, endX, 2 * n - endY));
            }
            if (!(startX == endX && startY > endY)){
                minDist = Math.min(minDist, cal(startX, startY, endX, -endY));
            }
            if (!(startY == endY && startX < endX)){
                minDist = Math.min(minDist, cal(startX, startY, 2 * m - endX, endY));
            }
            if (!(startY == endY && startX > endX)){
                minDist = Math.min(minDist, cal(startX, startY, -endX, endY));
            }
            result[i] = minDist;
        }
        return result;
    }
    
    public int cal(int sX, int sY, int eX, int eY) {
        return (sX - eX) * (sX - eX) + (sY - eY) * (sY - eY);
    }
}