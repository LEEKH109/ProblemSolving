import java.util.Scanner;
//이걸 비트 연산으로 어떻게 풀어요? 변환해서 하나?
public class Solution {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	// 암호코드 패턴
        String[] pattern = {
            "0001101", "0011001", "0010011", "0111101", "0100011",
            "0110001", "0101111", "0111011", "0110111", "0001011"
        };//모든 테스트 케이스에서 사용하므로 저장 해놓고 쓰는게 좋다.
        int T = sc.nextInt();//테스트 케이스 갯수
        for(int tc = 1; tc <= T; tc++) {
        	int N = sc.nextInt(); // 배열의 세로크기 1<=N<=50
            sc.nextInt(); // 배열의 가로크기 56<=M<=100 쓸일이 없다.
            // 문제예시를 보면 암호코드는 7비트 총 8개로 구성되어 있다고 한다.
            // 하지만 주어진 예시들을 보면 56이 아닌 70 80 100의 길이로 되어 있다.
            // 해당 숫자들에서 암호에 해당하는 숫자만 잘라내서 풀어야 한다. 따라서 입력을 받은 후 마지막1을 찾고
            // 해당 1부터 56개의 암호문을 잘라낸다.
            // 여기부터는 잘라낼 암호문을 찾는 과정
            String tmpCode = "";
            for (int i = 0; i < N; i++) {
                String firstLine = sc.next();
                if(firstLine.contains("1")) {
                	tmpCode = firstLine;
                	//샘플 인풋을 자세히 보면 첫번 째 암호문 줄부터 마지막 암호문 줄까지 유효 암호문은 동일하다.
                	//그렇지만 입력이 남았으므로 break;하면 안된다.
                } 
            }
            //이제 유효한 암호문만 잘라서 담아준다.
            int lastIdx = tmpCode.lastIndexOf('1');
            String validCode = tmpCode.substring(lastIdx - 55, lastIdx + 1);
            //암호문 정재 완료
            int[] decod = new int[8];//해독문의 숫자는 총 8개이다.
            for (int i = 0; i < 8; i++) {
                String partialCode = validCode.substring(i*7, (i+1)*7);
                for(int j = 0; j < 10; j++) {
                    if(partialCode.equals(pattern[j])) {
                        decod[i] = j;
                        break;
                    }
                }
            }
            
            // 검증
            int result = getSum(decod);
            System.out.println("#" + tc + " " + result);
        }//테스트케이스 
        sc.close();
    }
//    private static int getSum(int[] code) {//문제에서 주어진 조건으로 합 구하는 함수
//        int oddSum = 0, evenSum = 0;
//        for(int i = 0; i < 7; i++) {
//            if((i & 1) == 0) oddSum += code[i];
//            else evenSum += code[i];
//        }
//
//        if ((oddSum * 3 + evenSum + code[7]) % 10 == 0) {
//            int sum = 0;
//            for(int num : code) sum += num;
//            return sum;
//        } else {
//            return 0;
//        }
//    }

    private static int getSum(int[] code) {
        int oddSum = 0, evenSum = 0;
        for(int i = 0; i < 7; i++) {
            if(i % 2 == 0) oddSum += code[i];
            else evenSum += code[i];
        }
        if ((oddSum * 3 + evenSum + code[7]) % 10 == 0) {
            int sum = 0;
            for(int num : code) sum += num;
            return sum;
        } else {
            return 0;
        }
    }
}