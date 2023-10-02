import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		//팰린드롬수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String num;//입력받은 수
		boolean result;//결과
		
		while(true) {
			num = br.readLine();
			result = true;
			if(num.equals("0")) {
				//0이면 입력종료
				break;
			}
			for(int i = 0; i < num.length() / 2; i++) {
				if(num.charAt(i) != num.charAt(num.length() - 1 - i)) {
					//팰린드롬수가 아닌경우
					result = false;
					break;
				}
			}	
			if(result) {
				System.out.println("yes");
			}else {
				System.out.println("no");
			}
		}
		br.close();
	}
}