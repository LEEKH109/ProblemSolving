import java.io.*;

public class Main{
    static int[] arr;
    static int[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];
        
        String line[] = br.readLine().split(" ");
        
        int result = 0;
        for(int i=0; i < N; i++){
            arr[i] = Integer.parseInt(line[i]);
            dp[i] = 1;
            for(int j=i-1; j >= 0; j--){
                if(arr[i] < arr[j] && dp[i] <= dp[j]){
                    dp[i] = dp[j] + 1;
                }
            }
            result = Math.max(result, dp[i]);
        }
        
        bw.write(String.valueOf(result));
        br.close();
        bw.flush();
    }
}