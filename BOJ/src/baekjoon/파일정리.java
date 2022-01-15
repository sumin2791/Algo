package baekjoon;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class 파일정리 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String file = sc.next();
            String type = file.substring(file.indexOf(".") + 1);
            if (map.containsKey(type)) {
                int cnt = map.get(type);
                map.put(type, cnt + 1);
            } else {
                map.put(type, 1);
                list.add(type);
            }
        }

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            String name = list.get(i);
            System.out.println("name " + map.get(name));
        }

    }
}
