import java.util.Scanner;

public class Main {

    static int N, cnt, sqrt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        cnt = 0;
        sqrt = (int) Math.sqrt(N);
        for (int i = 1; i <= sqrt; i++) {
            cnt += N / i - (i - 1);
        }
        System.out.println(cnt);
    }
}
