class Solution {
    public int solution(String[][] board, int h, int w) {
        int[] dx = {0,1,-1,0};
        int[] dy = {1,0,0,-1};
        int n = board.length;
        int count = 0;
        String targetColor = board[h][w];
        for(int i = 0; i < 4; i++){
            int tmpX = h+dx[i];
            int tmpY = w+dy[i];
            if(tmpX < n && tmpX >= 0 && tmpY < n && tmpY >= 0 && targetColor.equals(board[tmpX][tmpY])){
                count++;
            }
        }
        return count;
    }
}