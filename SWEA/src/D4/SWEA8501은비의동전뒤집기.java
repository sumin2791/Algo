package D4;

import java.util.Arrays;
import java.util.Scanner;


public class SWEA8501은비의동전뒤집기 {
    public static void main(String[] args) {
         
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
         
        long[] facto = new long[1001];
        long[] dp = new long[1001];
        long MOD = 1_000_000_007;
         
        facto[0] = 1;
        for(int i = 1; i <= 1000; i++) {
            facto[i] = (facto[i - 1] * i) % MOD;
        }
        dp[1] = 0;
        for(int i = 2; i <= 1000; i++) {
            dp[i] = (((dp[i - 1] * i) % MOD) + ((i / 2) * facto[i - 1]) % MOD) % MOD;
        }
         
        for(int test_case = 1; test_case <= T; test_case++) {
            int N = input.nextInt();
            System.out.println("#" + test_case + " " + dp[N]);
        }
    }
}
