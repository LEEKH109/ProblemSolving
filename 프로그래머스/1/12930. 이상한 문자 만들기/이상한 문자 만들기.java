class Solution {
    public String solution(String s) {
        char[] words = s.toCharArray();
        String result = "";
        int idx = 0;
        for(int i = 0; i < words.length; i++){
            if(words[i] == ' '){
                idx = 0;
            }else if(idx % 2 == 0){
                words[i] = Character.toUpperCase(words[i]);
                idx++;
            }else {
                words[i] = Character.toLowerCase(words[i]);
                idx++;
            }
        }
        result = new String(words);
        return result;
    }
}