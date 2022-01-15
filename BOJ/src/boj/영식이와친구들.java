package boj;
import java.util.Scanner;

public class 영식이와친구들 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 사람수
        int M = sc.nextInt(); // 공 최대 횟수
        int L = sc.nextInt(); // 던지는거리
        int ball[] = new int[N]; // 공 횟수 배열
        int pos = 0; // 공 던지는 위치
        int cnt = 0;
        while (true) {
            ball[pos]++;
            if (ball[pos] == M) {
                break;
            }

            if (ball[pos] % 2 == 0) {// 홀수
                if ((pos + L) >= N) {
                    pos = pos + L - N;
                } else {
                    pos += L;
                }
            } else {// 짝수
                if ((pos - L) < 0) {
                    pos = pos - L + N;
                } else {
                    pos -= L;
                }
            }

            cnt++;
        }
        System.out.println(cnt);

    }
}
