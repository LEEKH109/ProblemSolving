class Solution {
    public int solution(int[][] sizes) {
        // 1단계, 명함에서 가장 긴 부분을 가로(w)로 통일한다.
        // 2단계, 가장 긴 가로와 세로를 갱신한다.
        int widthMax = 0;
        int heigthMax = 0;
        for(int i = 0; i < sizes.length; i++){
            if(sizes[i][0] < sizes[i][1]){
                int tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            }
            widthMax = Math.max(sizes[i][0], widthMax);
            heigthMax = Math.max(sizes[i][1], heigthMax);
        }
        // 3단계, 결과 출력
        int answer = widthMax * heigthMax;
        return answer;
    }
}