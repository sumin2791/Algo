package boj;
import java.util.Scanner;

public class 멅티버스1 {

    static int M, N, Ans;
    static int[][] arr;
    static boolean v[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력
        M = sc.nextInt();
        N = sc.nextInt();
        arr = new int[M][N]; // 반별 학생 점수 넣을 배열
        v = new boolean[M][M]; // 중복체크 하기 위함
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // 두 반씩 모두 비교하기 위해 반복문
        for (int i = 0; i < M - 1; i++) {
            for (int j = 1; j < M; j++) {
                find(i, j);
            }
        }
        System.out.println(Ans);

    }

    // 실력이 비슷한 두 반 찾기
    private static void find(int i, int j) {
        if (i == j)
            return; // 자기 반 두개인 경우 바로 리턴

        for (int n = 0; n < N - 1; n++) { // compare 함수 정의해서
                                          // 실력이 비슷하지 않은 경우는 리턴
            if (!compare(i, j, n))
                return;
        }
        if (!v[i][j] && !v[j][i]) { // 실력이 비슷한 경우 중복체크, 순서만 다른 경우는 한쌍이기 때문에 두 경우 모두 확인
            Ans++;
            v[i][j] = v[j][i] = true; // 답인 경우는 true값을 줌
            return;
        }
    }

    private static boolean compare(int i, int j, int k) {
        for (int n = k + 1; n < N; n++) { // k번 점수부터 마지막 점수까지 세가지 항목 모두 비교
                                          // k와 k+1 비교, k와 k+2 비교해서 끝까지 반복하여 하나라도 아닌 경우 false리턴
            if ((arr[i][k] > arr[i][n]) && (arr[j][k] <= arr[j][n]))
                return false;
            if ((arr[i][k] < arr[i][n]) && (arr[j][k] >= arr[j][n]))
                return false;
            if ((arr[i][k] == arr[i][n]) && (arr[j][k] != arr[j][n]))
                return false;
        }
        // 모두 만족시키는 경우 true 리턴함
        return true;
    }
}