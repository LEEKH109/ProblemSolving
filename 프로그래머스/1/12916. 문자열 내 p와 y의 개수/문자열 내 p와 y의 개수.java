import java.util.regex.Pattern;
import java.util.regex.Matcher;

class Solution {
    boolean solution(String s) {
        int countP = countOccurrences(s, "p");
        int countY = countOccurrences(s, "y");
        return countP == countY;
    }
    
    private int countOccurrences(String s, String ch) {
        Pattern pattern = Pattern.compile(ch, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(s);
        
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        
        return count;
    }
}