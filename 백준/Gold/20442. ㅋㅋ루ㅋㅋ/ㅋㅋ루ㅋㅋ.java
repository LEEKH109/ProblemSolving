import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] s = br.readLine().toCharArray();
        int n = s.length;

        ArrayList<Integer> leftK = new ArrayList<>();
        ArrayList<Integer> rightK = new ArrayList<>();
        
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == 'K') cnt++;
            else leftK.add(cnt);
        }

        cnt = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s[i] == 'K') cnt++;
            else rightK.add(cnt);
        }
        Collections.reverse(rightK);

        int start = 0;
        int end = leftK.size() - 1;
        int answer = 0;

        while (start <= end) {
            int leftVal = leftK.get(start);
            int rightVal = rightK.get(end);
            int length = (end - start + 1) + Math.min(leftVal, rightVal) * 2;
            answer = Math.max(answer, length);

            if (leftVal < rightVal) start++;
            else end--;
        }

        System.out.println(answer);
    }
}