import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // 입력을 위한 스캐너 선언
		int N = sc.nextInt(); // 스위치의 갯수 입력 
		int[] switchArr = new int [N]; //스위치 갯수만큼 배열 선언, 이 배열의 전체 스위치의 상태를 저장합니다.
		//배열의 초기값은 0으로 선언됩니다.
		for(int i = 0; i < N; i++) {
			switchArr[i] = sc.nextInt(); //조건문으로 1인 경우에만 입력해줘도 되지만 큰 차이가 없기 대문에 전부 다시 선언해줍니다.
		}//이를 통해 문제 상황에 맞는 스의치 상태가 배열에 입력됩니다.
		
		int M = sc.nextInt();// 학생 수를 입력 받습니다.
		for(int i = 0; i < M; i++) {
			int gender = sc.nextInt();//해당 학생의 성별을 입력 받습니다. 1은 남성, 2는 여성입니다.
			int workNum = sc.nextInt(); // 작동을 위한 변수를 입력받습니다.
			switch (gender) {
			case 1: {//남성 입니다.
				for(int j = 0; j < N; j++) {
					if((j+1)%workNum == 0) {
						switchArr[j] = 1-switchArr[j]; //작동변수의 배수이면 값을 반전 시켜 줍니다.
					}
				}
				break;
			}
			case 2: {//여성 입니다.
				int length = pelinNum(workNum-1, switchArr);
				for(int j = workNum-length; j< workNum-1+length; j++) {
					switchArr[j] = 1-switchArr[j];
				}
				break;
			}
			default:// 예외 처리입니다.
				break;
			}
			
		}
		sc.close(); // 입력이 끝났으므로 스위치 종료 
		//이제 출력단입니다.
		for(int i = 0; i < switchArr.length; i++) {
			System.out.print(switchArr[i]+ " ");
            if ((i+1) % 20 == 0) {
                System.out.println();
            }
		}
	}
	public static int pelinNum (int targetNum, int[] arr) {
		int N = 0;
		
		while(targetNum-N >= 0 && targetNum+N < arr.length) {
			if(arr[targetNum-N] == arr[targetNum+N]) {
				N++;
			}else {
				break;
			}
		}
		return N;
	}
}