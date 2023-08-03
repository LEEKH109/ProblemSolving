import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
    	//간단하게 생각해서 단어를 읽어나가면서 이전에 나온 적 있는 알파벳이 나오지만 않으면 되는거라고 생각해봅시다
        Scanner sc = new Scanner(System.in);
        int inputNum = sc.nextInt();
        sc.nextLine();  // 줄 바뀜 체크 
        int groupResult = 0;//  만족하는 결과의 경우를 저장 할 변수

        for(int i = 0; i < inputNum; i++) {
            String inputWord = sc.nextLine();
            boolean toggle = true;
            String[] strArr = new String[inputWord.length()];
            for (int j = 0; j < inputWord.length(); j++) {
                strArr[j] = String.valueOf(inputWord.charAt(j));
            }
            Set<String> strSet = new HashSet<>();
            for(int j = 0; j < strArr.length; j++) {
                if(j > 0 && strArr[j].equals(strArr[j-1])) {
                    continue;// 불 필요한 Set 호출 방지 
                }
                if(strSet.contains(strArr[j])) {
                    toggle = false;
                    break;
                } else {
                    strSet.add(strArr[j]);
                }
            }
            if(toggle) {
                groupResult++;// 한번이라도 규칙에 어긋나면 toggle이 false가 된다. 
            }
        }
        System.out.println(groupResult);
    }
}
