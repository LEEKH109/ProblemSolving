import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0; i < N ;i ++) {
			String tmp = sc.next();
			if(!list.contains(tmp)) {
				list.add(tmp);
			}
		}
		Collections.sort(list, (s1, s2) -> {
		    if (s1.length() != s2.length()) {
		        return Integer.compare(s1.length(), s2.length());
		    }
		    return s1.compareTo(s2);
		});
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i)+" ");
		}
		sc.close();
	}
}