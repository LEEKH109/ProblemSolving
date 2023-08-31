import java.util.Scanner;

public class Main {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(solveNQueens(N));
        sc.close();
    }
 
    public static int solveNQueens(int n) {
        int[][] board = new int[n][n];
        return solveNQueensUtil(board, 0);
    }
 
    private static int solveNQueensUtil(int[][] board, int col) {
        if (col >= board.length) {
            return 1;
        }
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            if (check(board, i, col)) {
                board[i][col] = 1;
                count += solveNQueensUtil(board, col + 1);
                board[i][col] = 0; // 백트래킹
            }
        }
 
        return count;
    }
 
    private static boolean check(int[][] board, int row, int col) {
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        for (int i = row, j = col; i < board.length && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }
}