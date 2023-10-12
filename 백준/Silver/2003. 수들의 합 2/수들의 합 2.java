import java.util.Scanner;

public class Main {
	static int N, target, cnt;
	static int arr[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		target = sc.nextInt();
		cnt = 0;
		arr = new int [N];
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		twoPointer();
		System.out.println(cnt);
		sc.close();
	}
	
	public static void twoPointer() {
		int sum = 0;
		int end = 0;
		for(int start = 0; start < N; start++) {
			while(sum < target && end < N) {
				sum += arr[end++];
			}
			if(sum == target) {
				cnt++;
			}
			sum -= arr[start];
		}
	}
}