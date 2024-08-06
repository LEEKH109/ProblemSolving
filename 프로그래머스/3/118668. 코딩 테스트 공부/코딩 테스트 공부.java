import java.util.*;
class Node{
    int alp, cop, cost;
    Node(int alp, int cop, int cost){
        this.alp = alp;
        this.cop = cop;
        this.cost = cost;
    }
}
class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int answer = 0;
        int max_alp = Integer.MIN_VALUE, max_cop = Integer.MIN_VALUE;
        int[][] v = new int[1000][1000];

        for(int i=0; i<problems.length; i++){
            if(max_alp<problems[i][0]){
                max_alp = problems[i][0];
            }
            if(max_cop<problems[i][1]){
                max_cop = problems[i][1];
            }
        }

        for(int i=0; i<v.length; i++){
            for(int j=0; j<v[0].length; j++){
                v[i][j] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>(){
            @Override
            public int compare(Node n1, Node n2){
                if(n1.cost<n2.cost){
                    return -1;
                }else if(n1.cost>n2.cost){
                    return 1;
                }else{
                    return 0;
                }
            }
        });

        pq.add(new Node(alp,cop,0));
        while(!pq.isEmpty()){
            Node n = pq.poll();
            if(n.alp >= max_alp && n.cop >= max_cop){
                return n.cost;
            }
            if(v[n.alp+1][n.cop]>n.cost+1){
                pq.add(new Node(n.alp+1,n.cop,n.cost+1));
                v[n.alp+1][n.cop] = n.cost+1;
            }

            if(v[n.alp][n.cop+1]>n.cost+1){
                pq.add(new Node(n.alp,n.cop+1,n.cost+1));
                v[n.alp][n.cop+1] = n.cost+1;
            }


            for(int i=0; i<problems.length; i++){
                if(n.alp>=problems[i][0]&&n.cop>=problems[i][1]&&v[n.alp+problems[i][2]][n.cop+problems[i][3]]>n.cost+problems[i][4]){
                    pq.add(new Node(n.alp+problems[i][2],n.cop+problems[i][3],n.cost+problems[i][4]));
                    v[n.alp+problems[i][2]][n.cop+problems[i][3]]=n.cost+problems[i][4];
                }
            }
        }


        return answer;
    }
}
