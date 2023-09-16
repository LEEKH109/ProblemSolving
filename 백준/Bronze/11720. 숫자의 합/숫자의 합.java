import java.util.Scanner;
    
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        String inputNum = sc.next(); // get the number as a String
        int sum = 0;
        for(int i = 0; i < count; i++) {
            int digit = inputNum.charAt(i) - '0'; // convert each character to its integer value
            sum += digit;
        }
        System.out.println(sum);
    }
}
