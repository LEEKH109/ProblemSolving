import java.util.Scanner;

public class Solution {
    static int D, W, K;
    static int[][] cell, copy; // copy는 얕은 복사용
    static int result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();//테스트 케이스 갯수 입력
        StringBuilder sb = new StringBuilder();//출력에러가 생겨서 테스트
        for (int tc = 1; tc <= T; tc++) {
            D = sc.nextInt();
            W = sc.nextInt();
            K = sc.nextInt();
            cell = new int[D][W];
            copy = new int[D][W];
            for (int x = 0; x < D; x++) {
                for (int y = 0; y < W; y++) {
                    cell[x][y] = sc.nextInt();
                }
            }
            result = K;
            if (K == 1) {//K가 1일 때는 비교 할 필요가 없이 그냥 0 출력하면 된다.
            	//테스트 케이스 50개 중 1개만 틀린다면 원인은 이 녀석
                result = 0;
            } else {
                dfs(0, 0);
            }
            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        sc.close();
        System.out.print(sb.toString());
    }

    public static void dfs(int depth, int cnt) {
        if (cnt >= result) return;// 전기톱 조건
        if (depth == D) {//이때만 최소값 비교
            if (check()) {
                result = Math.min(result, cnt);
            }
            return;
        }
        // 총 3가지 경우로 째야 되는데
        // 1. 줄의 값을 변경하지 않은 경우 2. A(0)으로 변경한 경우 3. B(1)로 변경한 경우
        // => 변경 원래 상태는 굳
        // 그래야 전부 탐색이 가능
        // 그리고 깊이를 계속 늘어나도록 해서 무한으로 안돌도록 설정
        // 변경하지 않음
        dfs(depth + 1, cnt);
        // A로 변경
        for (int i = 0; i < W; i++) {//직관성을 위해서는 반복문을 따로딸로 돌리는게 맞지만
        	//반복문 많이 돌리면 안 좋으므로 바로바로 바꿔 줍니다.
            copy[depth][i] = cell[depth][i];
            cell[depth][i] = 0;
        }
        // dfs 방식을 사용할 때 static으로 원본 배열을 올려놓고 수정하게 되면 다른 재귀에 영향이 가는 문제가 있으므로 수정 전에 
        // 원본 배열을 백업 해놓습니다. 어디에? 처음에 static으로 선언한 copy함수에
        dfs(depth + 1, cnt + 1);
        // B로 변경
        for (int i = 0; i < W; i++) {
            cell[depth][i] = 1;
        }
        dfs(depth + 1, cnt + 1);
        // 원래 상태로 복원
        for (int i = 0; i < W; i++) {
            cell[depth][i] = copy[depth][i];
        }//이러고 원본 배열을 복원해주면 이전에 다른 dfs 문제에서 사용했던 초기화 방식과 동일하게 해결이 됩니다.
        // 이게 핵심
    }

    public static boolean check() {
        for (int y = 0; y < W; y++) {
            boolean flag = false;
            int count = 1;
            for (int x = 0; x < D - 1; x++) {
                if (cell[x][y] == cell[x + 1][y]) {//바로 다음 칸과 비교
                    count++;
                    if (count >= K) {
                        flag = true;
                        break;
                    }
                } else {
                    count = 1;
                }
            }
            if (!flag) return false;
        }
        return true;
    }
}