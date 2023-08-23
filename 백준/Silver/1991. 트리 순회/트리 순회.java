import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nodeCnt = sc.nextInt();
		char [][] treeCarrier = new char[nodeCnt][3];
		sc.nextLine();// 안정적인 입력을 위한 처리
		for(int i = 0; i < nodeCnt; i++) {
			String[] tmp = sc.nextLine().split(" ");
			for(int j = 0; j <3; j++) {
				treeCarrier[i][j] = tmp[j].charAt(0); 
			}
		}// 입력 처리 끝 이제 트리가 이차원 배열안에 저장되어있다.
//		for(int i = 0; i < nodeCnt; i++) {
//			System.out.println(Arrays.toString(treeCarrier[i]));
//		}
		//이제 로직을 재귀로 돌리기 전에 탐색 로직을 생각해봅시다.
		order(treeCarrier, treeCarrier[0][0], 1);
		System.out.println("");
		order(treeCarrier, treeCarrier[0][0], 0);
		System.out.println("");
		order(treeCarrier, treeCarrier[0][0], -1);
		
		sc.close();
	}
	public static void order(char[][] arr, char target, int button) {
		int targetIdx = -1;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i][0] == target) {
				targetIdx = i;
			}
		}//해당 인덱스로 시작하는 배열 탐색 완료
		if(button == 1) {
			System.out.print(target);//해당 char 출력
		}
		if(arr[targetIdx][1] != '.') {
			order(arr, arr[targetIdx][1], button);
		}// 비어 있는 곳은 '.'으로 나타내므로 해당 구간은 재귀를 안돌리면 자동으로 정지 조건이 됩니다.
		if(button == 0) {
			System.out.print(target);//해당 char 출력
		}
		if(arr[targetIdx][2] != '.') {
			order(arr, arr[targetIdx][2], button);
		}
		if(button == -1) {
			System.out.print(target);//해당 char 출력
		}
	}
}