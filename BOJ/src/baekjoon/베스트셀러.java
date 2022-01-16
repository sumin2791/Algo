package baekjoon;

import java.util.HashMap;
import java.util.Scanner;

public class 베스트셀러 {

	public static void main(String[] args) {
		HashMap<String,Integer> map = new HashMap<>();
		String best = "";
		int max = 0;
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			String s = sc.next();
			int cnt = 0;
			if(map.containsKey(s)) {
				cnt = map.get(s);
				cnt++;
				map.put(s,cnt);
			}else {
				cnt = 1;
				map.put(s,1);
			}
			if(cnt>max) {
				best = s;
				max = cnt;
			}else if(cnt==max) {
				if(s.compareTo(best)<0) {
					 best = s;
				}
			}
		}
		
		System.out.println(best);
	}
}
