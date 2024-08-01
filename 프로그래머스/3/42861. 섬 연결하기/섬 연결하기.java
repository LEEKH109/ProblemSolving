// n개의 섬 사이에 다리를 건설하는 비용(costs)이 주어질 때, 최소의 비용으로 모든 섬이 서로 통행 가능하도록 만들 때 필요한 최소 비용
// => 모든 노드를 연결하면서, 비용 최소화 => 최소 비용 신장 트리(MST)
// 크루스칼 or 프림
// SWEA 1251 하나로
import java.util.*;

class Solution {
    static int[] arr;
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (int[]c1, int[]c2) -> c1[2]-c2[2]);

        arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = i;
        }
        int answer = 0;
        for(int i = 0; i < costs.length; i++){
            int start = costs[i][0];
            int startNode = findNode(start);
            int end = costs[i][1];
            int endNode = findNode(end);
            int cost = costs[i][2];

            if(startNode == endNode) continue;// 같은 그래프로면 패스

            answer += cost;
            arr[endNode] = startNode;

        }
        return answer;
    }

    private int findNode(int tmp){
        if(arr[tmp] == tmp){ // 같은 노드 찾음
            return tmp;
        }else{ // 못 찾으면 찾으러 떠나기, 재귀 호출
            return arr[tmp] = findNode(arr[tmp]);
        }
    }
}