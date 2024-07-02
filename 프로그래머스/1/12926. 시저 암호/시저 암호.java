class Solution {
    public String solution(String s, int n) {
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == ' ') continue;
            if(arr[i] <= 'Z'){ // 대문자일 경우
                arr[i] = (char) ((arr[i] - 'A' + n) % 26 + 'A');
            } else if (arr[i] <= 'z'){ // 소문자일 경우
                arr[i] = (char) ((arr[i] - 'a' + n) % 26 + 'a');
            }
        }
        return new String(arr);
    }
}
// class Solution {
//     public String solution(String s, int n) {
//         // 아스키로 간단하게 생각?
//         // 대문자 65 ~ 90 소문자 97 ~ 122 아스키 범위 정하기
//         char[] arr = s.toCharArray();
//         for(int i = 0; i < arr.length; i++){
//             if(arr[i] == ' ') continue;
//             if(arr[i] < 91){
//                 if(arr[i] + n > 90){
//                     arr[i] = (char) (arr[i] + n - 26);
//                 }else{
//                     arr[i] = (char) (arr[i] + n);
//                 }
//             }else{
//                 if(arr[i] + n > 122){
//                     arr[i] = (char) (arr[i] + n - 26);
//                 }else{
//                     arr[i] = (char) (arr[i] + n);
//                 }
//             }
//         }
//         String answer = new String(arr);
//         return answer;
//     }
// }