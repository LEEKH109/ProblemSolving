import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>(); 
        int n = elements.length;
        for (int c = 1; c <= n; c++) { 
            for (int i = 0; i < n; i++) {
                int sum = 0;
                for (int j = 0; j < c; j++) {
                    sum += elements[(i + j) % n];
                }
                set.add(sum); 
            }
        }
        return set.size();
    }
}