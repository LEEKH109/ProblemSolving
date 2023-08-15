// [ 문제 정의 ]
// "기러기", "토마토", "역삼역", "우영우" 와 같이 똑바로 읽어도 거꾸로 읽어도 똑같은 문장이나 낱말을 회문
// 8x8 평면 글자판에서 지정된 길이를 가진 회문의 개수를 구하기 
// [ 입력 ] 
// 테스트 케이스는 10개 고정 
// 입력 배열은 8X8 크기 고정
// CBBCBAAB 한줄씩 입력된다.
// 지정 회문길이와 입력배열이 순서대로 들어온다.
// [ 주의 사항 ]
// 1. 출력시 테스트 케이스 번호 붙여주기
// [ 풀이 방식 ]
// 오목판정문제와 동일하게 기준 좌표를 중심으로 상하 좌우를 검사한다. 
// 문자의 길이가 최대 8이기 때문에 배열의 앞뒤를 순차적으로 브루트 포스한다.
// 로직은 간단하지만 델타를 사용하기 때문에 배열 범위 밖으로 나가는 경우를 조심한다.
// 추가로 문자입력이 까다롭기 때문에 주의한다.
// 꼭 코드 작성하면 배열 잘 받아지는지 테스트 해야된다

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = 8;
		for(int tc = 1; tc <= 10; tc++) {
			int targetLeng = sc.nextInt();
			int cnt = 0;
			char [][] tmpArr = new char [N][];//char가 메모리도 적게 들고, 비교문 만들기도 쉽다
			for(int x = 0; x < N; x++) {
				tmpArr[x] = sc.next().toCharArray();
			}//입력 끝
			//방향 2갠데 델타 쓰는 것 도 좀 그르네요
			//가로 순회입니다.
			for(int y = 0; y < N; y++) {
				for(int x = 0; x < N; x++) {
					if(y+targetLeng <= N) {// 범위제한에 조심해야 합니다.
						boolean toggle = true;
						for(int i = 0; i < targetLeng; i++) {
							if(tmpArr[x][y+i] != tmpArr[x][y+targetLeng-1-i]) {
								toggle = false;
								break;// 반복문을 정지하고 toggle을 false로 변경
							}
						}
						if(toggle) {
							cnt++;
						}
					}else {
						continue;
					}
				}
			}//이중 배열 가로 순회 끝
			//세로 순회입니다.
			for(int y = 0; y < N; y++) {
				for(int x = 0; x < N; x++) {
					if(x+targetLeng <= N) {
						boolean toggle = true;
						for(int i = 0; i < targetLeng; i++) {
							if(tmpArr[x+i][y] != tmpArr[x+targetLeng-1-i][y]) {
								toggle = false;
								break;// 반복문을 정지하고 toggle을 false로 변경
							}
						}
						if(toggle) {
							cnt++;
						}
					}else {
						continue;
					}
				}
			}//이중 배열 세로 순회 끝
			System.out.println(String.format("#%d %d", tc, cnt));
		}//테스트 케이스 반복 
	}//main 함수
}