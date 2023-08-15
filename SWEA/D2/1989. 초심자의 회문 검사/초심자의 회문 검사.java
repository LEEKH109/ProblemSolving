// [ 문제 정의 ]
// "level" 과 같이 거꾸로 읽어도 똑같은 단어를 회문이라고 한다. 회문인지 판단하는 코드를 짠다.
// 입력을 받은 후 회문이면 1 아니면 0을 출력한다.
// [입력 범위] 
// 각 단어의 길이는 3 이상 10 이하 =>짝수가 올 수 도 있다.
// [ 풀이 방식 ]
// 단어의 길이가 홀수라면 배열로 만든 후 중앙부터 동시에 탐색하면 되지만 단어의 길이가 짝수 일 수도 있으므로
// 단어 배열의 양 끝에서부터 탐색해 준다.
// [ 주의 사항 ]
// 1. 출력시 테스트 케이스 번호 붙여주기
// 2. 출력 값이 0과 1인지 확인하기 
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		for(int tc = 1; tc <= test_case; tc++) {
			int result = 1;// 문제가 없으면 1을 출력하도록 초기값을 1로 잡아준다. 
			String []tmp = sc.next().split("");
			int middleNum = 0; 
			// 이번 문제는 단어의 길이가 작아서 배열 전체 길이를 탐색해도 좋지만 단어가 길어진다면 
			// 절반 만 탐색하는게 효율적이기 때문에 중앙값을 잡아준다.
			if(tmp.length%2 == 0) {
				middleNum = tmp.length/2; // 길이가 8이면 4가 나오므로 0~3까지만 딱 절반 탐색한다. 
			}else {
				middleNum = (tmp.length-1)/2;// 길이가 7이면 3이 나오므로 중간 인덱스 3을 제외한 0~2까지만 딱 절반 탐색한다. 
			}
			for(int i = 0; i < middleNum; i++) {
				if(!tmp[i].equals(tmp[tmp.length-1-i])) {
					result = 0;// 일치하지 않는 경우가 1번이라도 생기면 회문이 아니므로
					break;// 반복문을 정지하고 0을 출력한다.
				}
			}
			System.out.println(String.format("#%d %d", tc, result));
		}
	}
}