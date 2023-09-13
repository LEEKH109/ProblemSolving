import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			queue.add(i);
		} // 카드 세팅 완료
		sc.close();

		while (queue.size() > 1) {
			queue.remove();// 첫 번째 카드 삭제
			queue.add(queue.poll());// 맨 위 값을 빼서 바로 밑으로 넣습니다.
		}
		System.out.println(queue.poll());
	}
}