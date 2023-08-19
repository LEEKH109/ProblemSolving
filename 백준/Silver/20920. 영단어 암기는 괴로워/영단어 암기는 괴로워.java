import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        // 더 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        int N = Integer.parseInt(nm[0]); // 총 입력될 단어의 갯수
        int M = Integer.parseInt(nm[1]); // 기록할 단어의 최소길이

        Map<String, Integer> map = new HashMap<>(); // 단어들을 저장 할 해시맵, key값이 순서없이 저장됨에 주의
        
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            if (input.length() >= M) {
                if(map.containsKey(input)) { // 해당 단어가 이미 map에 있다면
                    map.put(input, map.get(input) + 1); // value 값 1 더해주기 
                } else {
                    map.put(input, 1); // 없다면 객체에 value 1로 추가해주기 
                }
            }
        }

        List<String> result = new ArrayList<>(map.keySet()); // 지헌스가 알려준 어레이 리스트에 키값 넣어서 정렬하기
        
        result.sort((key1, key2) -> {
            // 키값을 매개값으로 해서 위의 규칙 1,2,3 순으로 정렬합니다. 1번 규칙부터 가장 중요합니다.
            int value1 = map.get(key1);
            int value2 = map.get(key2);
            if (value1 == value2) {
                if (key1.length() == key2.length()) {
                    return key1.compareTo(key2); // 규칙3번. 알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치한다.
                }
                return key2.length() - key1.length(); // 규칙2번. 해당 단어의 길이가 길수록 앞에 배치한다.
            }
            return value2 - value1; // 규칙1번. 자주 나오는 단어일수록 앞에 배치한다.
        });
        StringBuilder sb = new StringBuilder();
        for (String word : result) {
            sb.append(word).append("\n");
        }
        System.out.print(sb);
    }
}