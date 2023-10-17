import java.util.*;

public class Main {
	static int N;
	static int[] arr;
	static boolean[] visited, finished;
	static ArrayList<Integer> ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N + 1];
		visited = new boolean[N + 1];
		finished = new boolean[N + 1];
		ans = new ArrayList<>();
		for(int i = 1; i <= N; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i = 1; i <= N; i++) {
			if(!visited[i]) dfs(i);
		}
		
		Collections.sort(ans);
		System.out.println(ans.size());
		for(int num : ans) {
			System.out.println(num);
		}
		sc.close();
	}
	
	static void dfs(int now) {
		visited[now] = true;
		int next = arr[now];
		
		if(!visited[next]) dfs(next);
		else {
			if(!finished[next]) {
				for(int i = next; i != now; i = arr[i]) {
					ans.add(i);
				}
				ans.add(now);
			}
		}
		finished[now] = true;
	}
}