package boj;

import java.util.Scanner;

public class 팰린드롬인지확인하기{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int answer = 1;
        while (s.length() > 1) {
            String first = s.substring(0, 1);
            String last = s.substring(s.length() - 1);
            if (first.equals(last)) {
                s = s.substring(1, s.length() - 1);
            } else {
                answer = 0;
                break;
            }
        }
        System.out.println(answer);

    }
}
