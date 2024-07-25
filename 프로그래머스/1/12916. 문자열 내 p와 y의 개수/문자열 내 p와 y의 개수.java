class Solution {
    boolean solution(String s) {
        // Ver.2
        
        int countP = 0;
        int countY = 0;
        
        s = s.toLowerCase();
        for (char ch : s.toCharArray()) {
            if (ch == 'p') {
                countP++;
            } else if (ch == 'y') {
                countY++;
            }
        }
        return countP == countY;
        // Ver.1
        // String[] tmp = s.split("");
        // int countP = 0;
        // int countY = 0;
        // for(String el : tmp){
        //     if(el.equals("p") || el.equals("P")){
        //         countP++;
        //     } else if(el.equals("y") || el.equals("Y")){
        //         countY++;
        //     } 
        // }
        // if(countP != countY){
        //     return false;
        // }else{
        //     return true;
        // }
    }
}