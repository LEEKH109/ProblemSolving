import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Integer>[] nodeList = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            nodeList[i] = new ArrayList<>();
        }
        int pairCount = sc.nextInt();
        for (int i = 0; i < pairCount; i++) {
            int index = sc.nextInt();
            int value = sc.nextInt();
            nodeList[index].add(value);
            nodeList[value].add(index);  // 양방향 연결 정보 추가
        }
        sc.close();

        boolean[] infected = new boolean[N + 1];
        infected[1] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1); // 1번 노드에서 BFS 시작

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int next : nodeList[current]) {
                if (!infected[next]) {
                    infected[next] = true;
                    queue.add(next);
                }
            }
        }

        int count = 0;
        for (int i = 2; i <= N; i++) {
            if (infected[i]) {
                count++;
            }
        }
        System.out.println(count);
    }
}