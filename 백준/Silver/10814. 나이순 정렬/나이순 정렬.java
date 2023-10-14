import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Member {
    int age;
    String name;
    Member(int age, String name) {
        this.age = age;
        this.name = name;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Member[] members = new Member[N];

        for (int i = 0; i < N; i++) {
            int age = sc.nextInt();
            String name = sc.next();
            members[i] = new Member(age, name);
        }

        Arrays.sort(members, new Comparator<Member>() {
			// 나이순으로 정렬
			@Override
			public int compare(Member m1, Member m2) {
				return m1.age - m2.age;
			}
			
		});
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(members[i].age).append(" ").append(members[i].name).append("\n");
        }
        System.out.print(sb.toString());
        sc.close();
    }
}