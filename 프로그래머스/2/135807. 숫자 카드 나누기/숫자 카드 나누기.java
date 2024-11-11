import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int gcdA = arrayA[0], gcdB = arrayB[0];
        
        for (int a : arrayA){
            gcdA = gcd(gcdA, a);
        } 
        for (int b : arrayB){
            gcdB = gcd(gcdB, b);
        }
        int resultA = div(gcdA, arrayB) ? gcdA : 0;
        int resultB = div(gcdB, arrayA) ? gcdB : 0;
        
        return Math.max(resultA, resultB);
    }
    
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    private boolean div(int tmp, int[] array) {
        for (int num : array) {
            if (num % tmp == 0) return false;
        }
        return true;
    }
}