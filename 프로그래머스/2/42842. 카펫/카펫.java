class Solution {
    public int[] solution(int brown, int yellow) {
        int area = brown + yellow;
        // 2x+2y-4 = brown; => x+y = (brown+4)/2
        // x-y = Math.sqrt((x+y)*(x+y) - 4*area);
        // 2x = (brown+4)/2 + Math.sqrt((x+y)*(x+y) - 4*area);
        int x = (int)(((brown + 4) / 2.0 + Math.sqrt((brown + 4) / 2.0 * (brown + 4) / 2.0 - 4 * area)) / 2);
        return new int[] {Math.max(x, area / x), Math.min(x, area / x)};
    }
}

// 초안
// import java.util.*;
// class Solution {
//     public int[] solution(int brown, int yellow) {
//         int area = brown + yellow;
//         int[] answer = new int[2];
//         int y = 0;
//         for(int x = 1; x <= area; x++){
//             if(area % x != 0) continue;
//             y = area / x;
//             if(2*x+2*y-4 == brown){
//                 answer[0] = Math.max(x,y);
//                 answer[1] = Math.min(x,y);
//                 break;
//             }
//         }
//         return answer;
//     }
// }
// xy 면적이 주어지고
// 주어진 값을 만족하는 x 와 y를 각각 구하는 문제