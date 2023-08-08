import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
	 Scanner sc = new Scanner(System.in);
	 int roomCnt = sc.nextInt();
	 long[] roomArr = new long[roomCnt];
	 for(int i = 0; i < roomCnt; i++) {
		 roomArr[i] = sc.nextInt();
	 }
	 long B = sc.nextInt();
	 long C = sc.nextInt();
	 long result = 0;
	 for(int j = 0; j < roomCnt; j++) {
		 long now = roomArr[j];
		 if(now >= B) {
			 result +=1;
			 now-=B;
		 }else {
			 result +=1;
			 continue;
		 }
		 if(now % C !=0) {
			 result+=(now/C+1);
		 }else {
			 result+=(now/C);
		 }
	 }
	 System.out.println(result);
	}
}
