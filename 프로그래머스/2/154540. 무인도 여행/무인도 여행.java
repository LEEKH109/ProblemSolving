// import java.util.*;

// class Solution {
//     static int[] dx = {0, 1, -1, 0};
//     static int[] dy = {1, 0, 0, -1};
//     public int[] solution(String[] maps) {
//         char[][] map = new char[maps.length][];
//         for(int i = 0; i < maps.length; i++){
//             map[i] = maps[i].toCharArray();
//         }
//         int m = map.length;
//         int n = map[0].length;
//         boolean[][] visited = new boolean[m][n];
//         Queue<int[]> queue = new LinkedList<>();
//         ArrayList<Integer> list = new ArrayList<>();
//         for(int x = 0; x < m; x++){
//             for(int y = 0; y < n; y++){
//                 if(!visited[x][y]){ // 해당 칸을 방문하지 않았다면
//                     if(map[x][y] == 'X'){
//                         visited[x][y] = true;
//                     }else{
//                         int sum = 0;
//                         queue.add(new int[]{x,y});// 해당 점을 queue에 넣고
//                         visited[x][y] = true;
//                         while(!queue.isEmpty()){
//                             int[] co = queue.poll();
                            
//                             int tmp = (map[co[0]][co[1]] - '0');
//                             sum+=tmp;
                            
//                             for(int i = 0; i < 4; i++){
//                                 int nx = co[0] + dx[i];
//                                 int ny = co[1] + dy[i];
//                                 if (nx < m && nx >= 0 && ny < n && ny >= 0 && !visited[nx][ny] && map[nx][ny] != 'X') {
//                                     queue.add(new int[]{nx, ny});
//                                     visited[nx][ny] = true;
//                                 }
//                             }
//                         }
//                         System.out.println(sum);
//                         list.add(sum);
//                     }
//                 }
//             }
//         }
//         if(list.size() == 0){
//             return new int[]{-1};
//         }else{
//             int[] answer = new int[list.size()];
//             for(int i = 0; i < list.size(); i++){
//                 answer[i] = list.get(i).intValue();
//             }
//             Arrays.sort(answer);
//             return answer;
//         }
//     }
// }

import java.util.*;

class Solution {
    static int[] dx = {0, 1, -1, 0}; // 이동 방향 x 좌표 변화량
    static int[] dy = {1, 0, 0, -1}; // 이동 방향 y 좌표 변화량
    
    public int[] solution(String[] maps) {
        int m = maps.length;
        int n = maps[0].length();
        
        // 문자 맵을 2차원 배열로 변환
        char[][] map = new char[m][n];
        for (int i = 0; i < m; i++) {
            map[i] = maps[i].toCharArray();
        }

        boolean[][] visited = new boolean[m][n];
        List<Integer> list = new ArrayList<>(); // sum 결과를 저장할 리스트
        
        // 모든 좌표 탐색
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (!visited[x][y] && map[x][y] != 'X') {
                    list.add(bfs(map, visited, x, y, m, n)); // BFS 탐색 후 결과 추가
                }
            }
        }

        // 결과가 없을 경우 -1 반환
        if (list.isEmpty()) {
            return new int[]{-1};
        }
        
        // 결과를 배열로 변환 후 정렬
        int[] answer = new int[list.size()]; // 크기가 같은 배열 생성
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i); // ArrayList에서 값을 하나씩 배열로 복사
        }
        Arrays.sort(answer); // 배열 정렬
        return answer;
    }

    // BFS 탐색 함수: 주어진 좌표에서 인접한 숫자들의 합을 계산
    private int bfs(char[][] map, boolean[][] visited, int x, int y, int m, int n) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        
        int sum = 0;
        
        while (!queue.isEmpty()) {
            int[] co = queue.poll();
            int cx = co[0];
            int cy = co[1];

            // 현재 위치의 숫자를 더함
            sum += (map[cx][cy] - '0');
            
            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                // 범위 내에 있고, 방문하지 않았으며, 'X'가 아닌 경우만 탐색
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny] && map[nx][ny] != 'X') {
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        return sum;
    }
}
                    