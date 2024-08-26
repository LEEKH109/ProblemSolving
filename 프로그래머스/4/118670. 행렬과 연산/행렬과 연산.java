import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[][] solution(int[][] rc, String[] operations) {
        int r = rc.length;
        int c = rc[0].length;

        Deque<Deque<Integer>> rows = new ArrayDeque<>();
        for (int[] row : rc) {
            Deque<Integer> newRow = new ArrayDeque<>();
            for (int j = 1; j < c - 1; j++) {
                newRow.add(row[j]);
            }
            rows.add(newRow);
        }

        Deque<Integer> firstCol = new ArrayDeque<>();
        Deque<Integer> lastCol = new ArrayDeque<>();
        for (int[] row : rc) {
            firstCol.add(row[0]);
            lastCol.add(row[c - 1]);
        }

        for (String op : operations) {
            if (op.equals("ShiftRow")) {
                rows.addFirst(rows.removeLast());
                firstCol.addFirst(firstCol.removeLast());
                lastCol.addFirst(lastCol.removeLast());
            } else if (op.equals("Rotate")) {
                rows.getLast().addLast(lastCol.removeLast());
                firstCol.addLast(rows.getLast().removeFirst());
                rows.getFirst().addFirst(firstCol.removeFirst());
                lastCol.addFirst(rows.getFirst().removeLast());
            }
        }

        int[][] result = new int[r][c];
        for (int i = 0; i < r; i++) {
            result[i][0] = firstCol.pollFirst();
            int j = 1;
            for (int val : rows.pollFirst()) {
                result[i][j++] = val;
            }
            result[i][c - 1] = lastCol.pollFirst();
        }

        return result;
    }
}