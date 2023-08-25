import java.util.Scanner;

public class Solution {

    public static int[] heap = new int[100000]; // 수업시간 보다 더 큰 충분한 크기의 배열
    public static int heapSize = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 수

        for (int tc = 1; tc <= T; tc++) {
            heap = new int[100000]; // 힙 초기화
            heapSize = 0; // 힙 크기 초기화

            int N = sc.nextInt(); // 연산의 수
            System.out.print("#" + tc + " ");

            for (int i = 0; i < N; i++) {
                int work = sc.nextInt(); // 연산 타입
                if (work == 1) { // 1: 삽입
                    int value = sc.nextInt();
                    heapPush(value);
                } else if (work == 2) { // 2: 추출
                    int result = heapPop();
                    System.out.print(result + " ");
                }
            }
            System.out.println();
        }
        sc.close();
    }

    public static void heapPush(int item) {
        heap[++heapSize] = item;
        int ch = heapSize;
        int p = ch / 2;

        while (p > 0 && heap[ch] > heap[p]) {
            int tmp = heap[p];
            heap[p] = heap[ch];
            heap[ch] = tmp;

            ch = p;
            p = ch / 2;
        }
    }

    public static int heapPop() {
        if (heapSize <= 0) return -1;

        int item = heap[1];
        heap[1] = heap[heapSize--];

        int p = 1;
        int ch = p * 2;
        if (ch + 1 <= heapSize && heap[ch] < heap[ch+1]) 
            ch += 1;

        while (ch <= heapSize && heap[p] < heap[ch]) {
            int tmp = heap[p];
            heap[p] = heap[ch];
            heap[ch] = tmp;
            p = ch;
            ch = p * 2;
            if (ch + 1 <= heapSize && heap[ch] < heap[ch+1])
                ch += 1;
        }
        return item;
    }
}