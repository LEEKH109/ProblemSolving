import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Integer>pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if(Math.abs(o1) == Math.abs(o2)) return o1-o2;
					// Min Heap이라는 가정 
					// 1. 양수가 반환 => o2가 더 작으므로 o2의 우선순위가 더 높다.
					// 2. 0이 반환 =>  o1과 o2의 우선순위가 동일 
					// 3. 음수가 반환 => o1가 더 작으므로 o1의 우선순위가 더 높다.
				return Math.abs(o1) - Math.abs(o2);
			}
		});
		for(int i = 0; i < N; i++) {
			int input = sc.nextInt();
			if(input == 0) {
				if(pq.isEmpty()) {
					System.out.println(0);
				}else {
					System.out.println(pq.poll());
				}
			}else {
				pq.add(input);
			}
		}
		sc.close();
	}
}