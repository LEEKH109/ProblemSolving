import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = 10; 
        for (int tcStart = 1; tcStart <= tc; tcStart++) {
            int tcNum = sc.nextInt();
            int arr_size = 100;
            int[][] tmpArr = new int[arr_size][arr_size];
            for (int yi = 0; yi < arr_size; yi++) {
                for (int xi = 0; xi < arr_size; xi++) {
                    tmpArr[xi][yi] = sc.nextInt();
                }
            } 

            int nowX = 0;
            for (int x = 0; x < arr_size; x++) {
                if (tmpArr[x][arr_size - 1] == 2) {
                    nowX = x;
                    int nowY = arr_size - 1;
                    while (nowY > 0) {
                        if (nowX >= 1 && tmpArr[nowX - 1][nowY] == 1) { // 왼쪽으로 이동 가능한 경우
                            while (nowX >= 1 && tmpArr[nowX - 1][nowY] == 1) {
                                nowX--; // 왼쪽으로 계속 이동

                            }nowY--; // 위로 이동
                        } else if (nowX <= arr_size - 2 && tmpArr[nowX + 1][nowY] == 1) { // 오른쪽으로 이동 가능한 경우
                            while (nowX <= arr_size - 2 && tmpArr[nowX + 1][nowY] == 1) {
                                nowX++; // 오른쪽으로 계속 이동
                                
                            }nowY--; // 위로 이동
                        } else {
                            nowY--; // 위로 이동
                        }
                    }
                    System.out.println("#" + tcNum + " " + nowX);
                    break; 
                }
            }
        }
        sc.close();
    }
}
