import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputCnt = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < inputCnt; i++) {
            String work = br.readLine();
            int arrSize = Integer.parseInt(br.readLine());
            String arrayString = br.readLine();
            arrayString = arrayString.substring(1, arrayString.length() - 1);
            String[] arrayVals = arrayString.split(",");
            Deque<Integer> deque = new ArrayDeque<>();
            for (int j = 0; j < arrSize; j++) {
                deque.add(Integer.parseInt(arrayVals[j].trim()));
            }
            String result = workTotal(work, deque);
            sb.append(result).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static String workTotal(String workInput, Deque<Integer> deque) {
        boolean reverse = false;
        for (char command : workInput.toCharArray()) {
            if (command == 'R') {
                reverse = !reverse;
            } else if (command == 'D') {
                if (deque.isEmpty()) {
                    return "error";
                }
                if (reverse) {
                    deque.removeLast();
                } else {
                    deque.removeFirst();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        while (!deque.isEmpty()) {
            sb.append(reverse ? deque.removeLast() : deque.removeFirst());
            if (!deque.isEmpty()) {
                sb.append(",");
            }
        }
        sb.append(']');
        return sb.toString();
    }
}
