import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main{

    static int N, M, tmp, ans;
    static int[][] map;
    static int[][] copy;
    static ArrayList<int[]> shop = new ArrayList<>(); // 치킨 가게 위치 저장
    static ArrayList<int[]> home = new ArrayList<>(); // 집 위치 저장
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        ans = Integer.MAX_VALUE;
        map = new int[N][N];
        copy = new int[N][N];
        
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                tmp = sc.nextInt();
                map[x][y] = tmp;
                if (tmp == 2) {
                    shop.add(new int[] { x, y });
                } else if (tmp == 1) {
                    home.add(new int[] { x, y });
                }
            }
        }

        visited = new boolean[shop.size()];
        partialMap(); 
        System.out.println(ans);
        sc.close();
    }

    public static void partialMap() {
        int masksize = shop.size();
        
        for (int mask = 0; mask < (1 << masksize); mask++) {
            if (Integer.bitCount(mask) == M) {
                for (int i = 0; i < N; i++) {
                    copy[i] = Arrays.copyOf(map[i], N);
                }

                Arrays.fill(visited, false);
                
                for (int idx = 0; idx < masksize; idx++) {
                    if ((mask & (1 << idx)) != 0) {
                        visited[idx] = true; 
                    } else {
                        int[] unSelected = shop.get(idx);
                        copy[unSelected[0]][unSelected[1]] = 0;
                    }
                }
                dfs(0, 0);
            }
        }
    }

    public static void dfs(int currentShopIdx, int count) {
        if (count == M) {
            int sum = 0;
            for (int[] h : home) {
                int minDistance = Integer.MAX_VALUE;
                for (int i = 0; i < shop.size(); i++) {
                    if (visited[i]) {
                        int distance = Math.abs(h[0] - shop.get(i)[0]) + Math.abs(h[1] - shop.get(i)[1]);
                        minDistance = Math.min(minDistance, distance);
                    }
                }
                sum += minDistance;
            }
            ans = Math.min(ans, sum);
            return;
        }

        if (currentShopIdx == shop.size()) return;

        // 현재 치킨집을 선택하는 경우
        if (visited[currentShopIdx]) {
            dfs(currentShopIdx + 1, count + 1);
        }

        // 현재 치킨집을 선택하지 않는 경우
        dfs(currentShopIdx + 1, count);
    }
}
