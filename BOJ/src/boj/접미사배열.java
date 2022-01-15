package boj;

import java.util.Arrays;
import java.util.Scanner;

public class 접미사배열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        String[] arr = new String[s.length()];
        for (int i = 0; i < s.length(); i++) {
            String suffix = s.substring(i);
            arr[i] = suffix;
        }

        Arrays.sort(arr);

        for (int i = 0; i < s.length(); i++) {
            System.out.println(arr[i]);
        }

    }
}
