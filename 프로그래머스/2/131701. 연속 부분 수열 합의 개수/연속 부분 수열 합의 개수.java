import java.util.*;

class Solution {
    public int solution(int[] elements) {
        ArrayList<Integer> l = new ArrayList<>();
        HashSet<Integer> set = new HashSet<Integer>();
        int n = elements.length;
        for(int c = 1; c <= n; c++){
            for(int i = 0; i < n; i++){
                int tmp = 0;
                for(int j = i; j < i+c; j++){
                    if(j < n){
                        tmp += elements[j];
                    }else{
                        tmp += elements[j-n];
                    }   
                }
                l.add(tmp);
                set.add(tmp);
            }
        }
        //System.out.println(l);
        return set.size();
    }
}
// 7 9 1 1 4
// 16,10,2,5,11
// 17,11,6,12,20