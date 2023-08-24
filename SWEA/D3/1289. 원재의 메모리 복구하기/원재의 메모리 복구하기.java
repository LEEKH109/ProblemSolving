import java.util.Scanner;
//원재는 미래도 보면서 도대체 왜 이러는 걸까
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);// 입력을 위한 스캐너 선언
		int T = sc.nextInt();//테스트케이스 갯수 입력
		for(int tc = 1; tc <= T; tc++) {
			char[] tmp = sc.next().toCharArray();//입력 숫자가 붙어있으므로 char로 받고 다시 int 배열로 전환할 겁니다.
			int N = tmp.length;// 전체 배열의 길이를 자주 사용하므로 따로 변수로 받습니다.
			int [] inputArr = new int [N];//초기화 전 원본 배열을 저장 할 int형 배열을 만들어줍니다.
			for(int i = 0; i < N; i++) {
				inputArr[i] = (tmp[i]-'0');
			}//원본 배열에 숫자 입력
			int [] initialArr = new int [N];// 초기값 0000, 그냥 입력 배열 만큼 초기화 배열 생성해주면 됩니다.
			int cnt = 0;// 몇번 작동해야 원본 배열과 같아지는지 기록
			Loop : for(int i = 0; i < N; i++) {
				if(initialArr[i] == inputArr[i]) {
					continue;// 같은 위치의 값이 같으면 더 할 것 없습니다. 패스
				}else {
					cnt++;// 값이 다르면 덮어씌워야하니까 cnt 1더해주고 작동하면 됩니다.
					for(int j = i; j < N ; j++) {//해당 인덱스 부터 끝까지 덮어씌울 겁니다.
						if(initialArr.equals(inputArr)) {//작동 전에 혹시라도 이미 원본 배열과 같아졌으면 작동 할 필요가 없으니까 정지 시킵니다.
							break Loop;// 모든 반복문을 정지
						}
						initialArr[j] = inputArr[i];// 현재 지정된 원본배열 값으로 기준 좌표부터 끝까지 전부 덮어 버립니다.
					}
				}
			}// 배열 전체 순회 종료
			System.out.println("#"+tc+" "+cnt);//결과 값 출력
		}
		sc.close();//입력 종료 스캐너 닫아줍니다.
	}
}