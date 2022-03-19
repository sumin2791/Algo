package baekjoon;

import java.util.Scanner;

public class 시간복잡도를배운도도 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int max = 0, cnt = 0;
		
		for (int tc = 0; tc < N; tc++) {
			String s = sc.next();
			s = s.replaceAll("for","0");
			s = s.replaceAll("while","0");
			
			cnt = 0;
			for (int i = 0; i < s.length(); i++) {
				if(s.charAt(i)=='0') {
					cnt++;
				}
			}
			max = Math.max(max,cnt);
		}
		
		System.out.println(max);
	}
}
