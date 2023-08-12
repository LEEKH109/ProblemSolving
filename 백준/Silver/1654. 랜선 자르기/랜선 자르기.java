import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int lanCnt = sc.nextInt();
		int K = sc.nextInt();
		long[] tmpArr = new long[lanCnt];
		long maxCut = 0;

		for (int tmp = 0; tmp < lanCnt; tmp++) {
			tmpArr[tmp] = sc.nextInt();
			maxCut = Math.max(maxCut, tmpArr[tmp]);
		}

		long minCut = 1; // 랜선의 최소 길이
		long resultCut = 0;
		long lanSum = 0;

		while (minCut <= maxCut) {
			long midCut = (minCut + maxCut) / 2;
			lanSum = 0;

			for (int tmp = 0; tmp < lanCnt; tmp++) {
				lanSum += (tmpArr[tmp] / midCut);
			}

			if (lanSum >= K) {
				resultCut = midCut;
				minCut = midCut + 1;
			} else {
				maxCut = midCut - 1;
			}
		}
		System.out.println(resultCut);
	}
}