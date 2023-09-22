import java.util.Scanner;
import java.util.Stack;

public class Solution {
	static int V, E;
	static int[][] adjArr;
	static int[] degree;
	static boolean[] visited;
	static Stack<Integer> stack;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc <= 10; tc++){
			V = sc.nextInt();// 정점 갯수
			E = sc.nextInt();// 간선 갯수
			//간선 정보를 담을 인접행렬 생성
			adjArr = new int[V + 1][V + 1];
			degree = new int[V + 1];// 진입차수를 저장할 배열을 하나 생성한다.
			visited = new boolean[V + 1];// 방문여부 체크
			stack = new Stack<>();// 진행 순서를 담을 스택
			
			for(int i = 0; i < E; i++) {
				int A = sc.nextInt();// 출발
				int B = sc.nextInt();// 끝
				// 유향이므로 A->B로'만' 저장
				// 이전 프림 다익스트라에서는 무향 그래프여서
				// adjArr[A][B] = 1;
				// adjArr[B][A] = 1; 이렇게 처리를 해줬다.
				adjArr[A][B] = 1;
				degree[B]++;// 왜 B일까? A->B 이므로
				// [0,1,2,3,4,5,6,7,8,9]
				// [0,1,1,1,0,2,1,1,0,1]
				// 이런 느낌으로 저장
			}
			for (int i = 1; i < V + 1; i++) {// 위의 진입차수 저장 배열을 순회 하면서
				if (degree[i] == 0) {// 진입차수가 0인 정점 체크
					DFS(i);
				}
			}
			System.out.print("#"+tc+" ");
			while (!stack.isEmpty()) {
				System.out.print(stack.pop()+" ");
			}
			System.out.println("");
		}
		sc.close();
	}
	
	private static void DFS(int v) {
		visited[v] = true;
		for (int i = 1; i < V + 1; i++) {
			if (adjArr[v][i] == 1 && !visited[i])
				DFS(i); 
		}
		stack.add(v);
	}
}