class Solution {
    public String solution(String s, int n) {
        // 아스키로 간단하게 생각?
        // 대문자 65 ~ 90 소문자 97 ~ 122 아스키 범위 정하기
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == ' ') continue;
            if(arr[i] < 91){
                if(arr[i] + n > 90){
                    arr[i] = (char) (arr[i] + n - 26);
                }else{
                    arr[i] = (char) (arr[i] + n);
                }
            }else{
                if(arr[i] + n > 122){
                    arr[i] = (char) (arr[i] + n - 26);
                }else{
                    arr[i] = (char) (arr[i] + n);
                }
            }
        }
        String answer = new String(arr);
        return answer;
    }
}