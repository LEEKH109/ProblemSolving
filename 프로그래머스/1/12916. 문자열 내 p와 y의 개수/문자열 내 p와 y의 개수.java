class Solution {
    boolean solution(String s) {
        String[] tmp = s.split("");
        int countP = 0;
        int countY = 0;
        for(String el : tmp){
            if(el.equals("p") || el.equals("P")){
                countP++;
            } else if(el.equals("y") || el.equals("Y")){
                countY++;
            } 
        }
        if(countP != countY){
            return false;
        }else{
            return true;
        }
    }
}