import java.util.Scanner;

public class  Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();//입력을 받아줍니다. 한국 사람이면 스캐너씁시다.
        for( int test_case = 1; test_case <= tc; test_case++ ) {
             
            // 이번 문제는 입력이 덱스트로 들어옵니다. 이걸 그대로 String 배열로 사용하기에는 문제가 있습니다.
            // 따라서 입력을 받으면서 char로 변환해서 char 배열을 만들어줍니다.
            // '.'와 'o' 를 각각의 자리에 넣어줍니다.
            // 이제 입력을 받아줍니다.
            int arr_size = sc.nextInt();
            char [][] tmpArr = new char [arr_size][];
            for (int x = 0; x < arr_size; x++) {
				tmpArr[x] = sc.next().toCharArray(); // nextLine()을 사용하면 공백까지 받아 버리므로 next()를 사용합니다.
			} // 이제 입력이 끝났습니다.
            //이제 수업내용에서 배운 팔방 탐색을 사용할 것 입니다.
            int[]dx = {1,1,1,0,0,-1,-1,-1};
            int[]dy = {1,0,-1,1,-1,1,0,-1};
            boolean result = false; // 이번 문제의 결과 값은 딱 두가지입니다. YES 아니면 NO 따라서 결과값을 담아 줄 변수를 그냥 boolean으로 처리합니다.\
            find: for(int y = 0; y < arr_size; y++) {
                for(int x = 0; x < arr_size; x++) {
                	if (tmpArr[x][y] != 'o') continue; // 시작점 부터 '.'이면 굳이 비교 할 필요 없습니다.
                    for(int i = 0; i <8; i++) {
                        int cnt = 0;
                        for(int k = -2; k <= 2; k++) {
                        	int nx = x + k * dx[i], ny = y + k * dy[i];
                            if(nx < 0 || nx >= arr_size || ny < 0 || ny >= arr_size) {
                                break;// 5칸을 검사하는데 1칸이라도 범위에서 벗어났다면 오목의 의미가 없으므로 break;
                            }
                            if(tmpArr[nx][ny] == '.'){
                                break;// 5칸을 검사하는데 1칸이라도 '.'이 나오면 오목의 의미가 없으므로 break;
                            }
                            cnt++;
                        }//해당 좌표의 8방위 순회가 끝나면 해당 cnt가 5가 되므로
                        if(cnt == 5) {
                            result = true;//이러면 오목이 하나 있다는 뜻
                            break find;
                        }
                    }
                }
            }
            //여기는 출력 부
            System.out.printf("#%d %s\n", test_case, result ? "YES" : "NO");
        }
    }
}