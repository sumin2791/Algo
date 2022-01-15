package boj;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class 듣보잡 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        HashSet<String> set = new HashSet<>();
        ArrayList<String> unknown = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            set.add(sc.next());
        }

        for (int i = 0; i < M; i++) {
            String s = sc.next();
            if (set.contains(s)) {
                unknown.add(s);
            }
        }

        Collections.sort(unknown);
        System.out.println(unknown.size());
        for (int i = 0; i < unknown.size(); i++) {
            System.out.println(unknown.get(i));
        }

    }
}
