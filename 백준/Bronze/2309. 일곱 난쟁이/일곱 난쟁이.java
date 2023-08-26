import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int [] arr = new int [9];
		int [] result = new int [7];
		for(int i = 0; i < 9 ; i++) {
			arr[i] = sc.nextInt();
		}
		for(int a = 0; a < 9; a++) {
			for(int b = a+1; b < 9; b++) {
				for(int c = b+1; c < 9; c++) {
					for(int d = c+1; d < 9; d++) {
						for(int e = d+1; e < 9; e++) {
							for(int f = e+1; f < 9; f++) {
								for(int g = f+1; g < 9; g++) {
									if(arr[a]+arr[b]+arr[c]+arr[d]+arr[e]+arr[f]+arr[g] == 100){
										int[] tmp =  { arr[a], arr[b], arr[c], arr[d], arr[e], arr[f], arr[g]};
										for(int i = 0; i < 7 ; i++) {
											result[i] = tmp[i];
										}
									}
								}
							}
						}
					}
				}
			}
		}
		Arrays.sort(result);
		for(int el : result) {
			System.out.println(el);
		}
		sc.close();
	}
}