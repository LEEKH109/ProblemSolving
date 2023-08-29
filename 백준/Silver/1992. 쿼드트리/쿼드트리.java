
import java.util.Scanner;

public class Main {
	private static String quadTree(int[][] arr) {
        if (arr.length == 1) {
            return String.valueOf(arr[0][0]);
        }//무한루프를 방지하기 위한 조건 => 가장 작은 단위에서는 STOP

        int n = arr.length / 2;

        // 왼쪽 위
        int[][] arrL = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arrL[i][j] = arr[i][j];
            }
        }

        // 오른쪽 위
        int[][] arrR = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = n; j < arr.length; j++) {
                arrR[i][j - n] = arr[i][j];
            }
        }

        // 왼쪽 아래
        int[][] arrU = new int[n][n];
        for (int i = n; i < arr.length; i++) {
            for (int j = 0; j < n; j++) {
                arrU[i - n][j] = arr[i][j];
            }
        }

        // 오른쪽 아래
        int[][] arrD = new int[n][n];
        for (int i = n; i < arr.length; i++) {
            for (int j = n; j < arr.length; j++) {
                arrD[i - n][j - n] = arr[i][j];
            }
        }
        String strL = quadTree(arrL);
        String strR = quadTree(arrR);
        String strU = quadTree(arrU);
        String strD = quadTree(arrD);

        //return (strL.equals(strR) && strL.equals(strU) && strL.equals(strD)) ? strL : "(" + strL + strR + strU +  strD + ")"; 이전 버전
        return (strL.equals(strR) && strL.equals(strU) && strL.equals(strD) && (strL.equals("0") || strL.equals("1"))) ? strL : "(" + strL + strR + strU +  strD + ")";
    }

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }
        System.out.println(quadTree(arr));
        sc.close();
   
    }
}