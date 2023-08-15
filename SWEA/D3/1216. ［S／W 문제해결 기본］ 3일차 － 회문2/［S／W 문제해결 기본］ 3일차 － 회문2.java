// [ 문제 정의 ]
// "기러기", "토마토", "역삼역","우영우" 같은 거꾸로 읽어도 제대로 읽은 것과 같은 문장이나 낱말을 회문이라고 합니다.
// 주어진 문자 배열은 100X100 고정 크기이고, 배열의 가로 세로를 전부 검토하여 가장 긴 회문의 길이를 출력 하는 문제입니다.
// 단, 회문은 직선형태만 인정합니다. 꺽이는 순간 회문이 아닙니다.
// [ 입력 ] 
// 테스트 케이스는 10개 고정
// 하지만, 테스트케이스 번호가 따로 입력됩니다. 처리해 줘야 합니다.
// 입력 배열은 100X100 크기 고정
// A,B,C가 섞인 100자리 문자열이 한줄씩 입력됩니다.
// [ 주의 사항 ]
// 1. 출력시 사전에 입력받은 테스트 케이스 번호를 붙여주기
// [ 풀이 방식 ]
// 완전 탐색 밖에 생각이 안납니다.
// 주어진 100칸짜리 일차원 배열이 회문인지 회문이라면 길이가 몇인지 판단하는 함수를 따로 만들어서
// 그 함수에 총 200번 대입 할까 생각합니다.
// 해당 함수는 0부터 99번 인덱스까지 시작 좌표를 이동하며 
// 99번 인데스부터 시작좌표 와 일치하는 알파벳이 있는지 검토하고 있다면 
// 시작좌표와 해당좌표까지 회문인지 검사 맞다면 그 사이 거리 출력
// 아니라면 다시 시작좌표와 같은 알파벳을 찾아서 이동합니다.
// 이런식으로 반복해서 회문이 있다면 해당 회문의 길이를 없다면 -1를 반환하는 함수를 만들어서 사용해볼까 합니다.
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);//입력을 받을 스캐너 설정
		for(int tc = 1; tc <= 10; tc++) {
			int tcNum = sc.nextInt();//입력에서 테스트케이스 번호가 입력되어서 받아줍니다.
			int N = 100;
			int maxLeng = 1; // 가장 깉 회문의 길이를 저장 할 변수 회문의 초기값이 1칸이므로 1로 지
			char [][] tmpArr = new char [N][];//A,B,C이므로 char로 받아줍니다.
			for(int x = 0; x < N; x++) {
				tmpArr[x] = sc.next().toCharArray();
			}//입력 배열 처리 끝 
			// 밑에 만들어둔 길이 반환 함수에 행을 순서대로 넣어서 검사합니다. 
            for (int x = 0; x < N; x++) {
                maxLeng = Math.max(maxLeng, gingeo(tmpArr[x])); //나온 결과 값을 이전 까지의 회문최대 길이와 비교해줍니다. 
            }

            // 밑에 만들어둔 길이 반환 함수에 열을 순서대로 넣어서 검사합니다. 
            // 단, 열은 배열 단순 참조로 가져오기 힘드므로 임시 배열을 만들어서 넣어줍니다.
            for (int y = 0; y < N; y++) {
                char[] tmpColumn = new char[N];
                for (int x = 0; x < N; x++) {
                    tmpColumn[x] = tmpArr[x][y];
                }// 생성해줄 때 주의 해야 합니다. 
                maxLeng = Math.max(maxLeng, gingeo(tmpColumn));//나온 결과 값을 이전 까지의 회문최대 길이와 비교해줍니다. 
            }
			
			
		System.out.println(String.format("#%d %d", tcNum, maxLeng));// 출력문 처리 끝	
		}
		sc.close();//다 쓰면 프로그램에서 알아서 꺼주기는 합니다만 닫아줍시다. 
	}
	
	// 회문이 맞는지 검사하는 함수입니다. 시작좌표와 맞은 편 끝 좌표가 교차하면 더 이상 검사 할 수 없으므로 종료합니다. 
	// 사실 이걸 이렇게 따로 검사하는게 맞는지 애매합니다. 이 함수로 인해 많이 느려집니다.
    public static boolean palindromeMaja(char[] arr, int start, int end) {
        while (start < end) {
            if (arr[start] != arr[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // 입력 받은 배열에서 가장 긴 회문의 길이를 반환하는 함수입니다. 
    public static int gingeo(char[] arr) {
        int max = 1; //왜 1이냐 알파벳 한칸 도 회문이라고 합니다. 
        // 이 함수 내에서도 회문의 최대 길이는 계속 변하기 때문에 함수 내에서도 최댓값 여부를 계속 비교해 줘야 합니다.
        for (int start = 0; start < arr.length; start++) {
            for (int end = arr.length - 1; end > start; end--) {
                if (arr[start] == arr[end] && palindromeMaja(arr, start, end)) {//매번 회문여부를 검사하는게 맞나 싶습니다. 
                	//최적화하게되면 회문 판정여부를 최대한 덜 하게 만들어 봐야 할 것 같습니다.
                    max = Math.max(max, end - start + 1);// 함수내의 회문 최대길이와 비교 
                    break;  // 최대 길이를 찾았다면 다음 시작 지점으로 이동
                }
            }
        }
        return max;
    }
}