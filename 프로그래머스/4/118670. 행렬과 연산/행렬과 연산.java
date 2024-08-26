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

        String lastOp = "";
        int opCount = 0;

        for (int i = 0; i < operations.length; i++) {
            String op = operations[i];
            if (op.equals(lastOp) || lastOp.equals("")) {
                opCount++;
            } else {
                applyOperation(rows, firstCol, lastCol, lastOp, opCount, r, c);
                opCount = 1;
            }
            lastOp = op;
        }
        applyOperation(rows, firstCol, lastCol, lastOp, opCount, r, c);  // Apply last accumulated operation

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

    private void applyOperation(Deque<Deque<Integer>> rows, Deque<Integer> firstCol, Deque<Integer> lastCol, String operation, int count, int r, int c) {
        if (operation.equals("ShiftRow")) {
            int shifts = count % r;
            for (int i = 0; i < shifts; i++) {
                rows.addFirst(rows.removeLast());
                firstCol.addFirst(firstCol.removeLast());
                lastCol.addFirst(lastCol.removeLast());
            }
        } else if (operation.equals("Rotate")) {
            int rotations = count % (2 * (r + c - 2));
            for (int i = 0; i < rotations; i++) {
                rotateOperation(rows, firstCol, lastCol);
            }
        }
    }

    private void rotateOperation(Deque<Deque<Integer>> rows, Deque<Integer> firstCol, Deque<Integer> lastCol) {
        rows.getLast().addLast(lastCol.removeLast());
        firstCol.addLast(rows.getLast().removeFirst());
        rows.getFirst().addFirst(firstCol.removeFirst());
        lastCol.addFirst(rows.getFirst().removeLast());
    }
}