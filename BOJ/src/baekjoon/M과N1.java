package baekjoon;
import java.util.Arrays;
import java.util.Scanner;

public class M과N1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int arr[] = new int[N];
        int sel[] = new int[M];
        boolean v[] = new boolean[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1; // 1부터
        }

        permutation(arr, sel, v, 0, 0);

    }

    private static void permutation(int arr[], int sel[], boolean v[], int index, int k) {
        if (k == sel.length) {
            for (int i = 0; i < sel.length; i++) {
                System.out.print(sel[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (v[i] != true) {
                v[i] = true;
                sel[k] = arr[i]; // 뽑기

                permutation(arr, sel, v, i + 1, k + 1);
                v[i] = false;

            }

        }

    }
}