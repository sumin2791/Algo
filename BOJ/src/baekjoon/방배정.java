package baekjoon;
import java.util.Scanner;

public class 방배정 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ans = 0;

        int student[][] = new int[6][2];
        int N = sc.nextInt();
        int K = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int gender = sc.nextInt();
            int grade = sc.nextInt();
            student[grade - 1][gender]++;
        }

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 2; j++) {
                int num = student[i][j];
                ans += num / K;
                if (num % K != 0)
                    ans++;
            }
        }

        System.out.println(ans);
    }
}