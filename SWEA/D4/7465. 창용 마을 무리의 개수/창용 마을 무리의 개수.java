import java.util.*;

public class Solution {
    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt(); // 사람의 수
            int M = sc.nextInt(); // 관계의 수

            parent = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                parent[i] = i;
            }

            for (int i = 0; i < M; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                union(a, b);
            }

            int count = 0;
            for (int i = 1; i <= N; i++) {
                if (parent[i] == i) count++;
            }

            System.out.println("#" + tc + " " + count);
        }
        sc.close();
    }

    static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]); 
    }

    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        
        if (rootX != rootY) {
            parent[rootY] = rootX;
        }
    }
}