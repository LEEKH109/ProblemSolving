class Solution {
    boolean solution(String s) {
        s = s.toLowerCase();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == 'p')
                count++;
            else if (s.charAt(i) == 'y')
                count--;
        }

        if (count == 0)
            return true;
        else
            return false;
    }
}
// import java.util.*;

// class Solution {
//     boolean solution(String s) {
//         int countP = countOccurrences(s, "p");
//         int countY = countOccurrences(s, "y");
//         return countP == countY;
//     }
    
//     private int countOccurrences(String s, String ch) {
//         Pattern pattern = Pattern.compile(ch, Pattern.CASE_INSENSITIVE);
//         Matcher matcher = pattern.matcher(s);
        
//         int count = 0;
//         while (matcher.find()) {
//             count++;
//         }
        
//         return count;
//     }
// }