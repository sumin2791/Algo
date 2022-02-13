package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 그룹단어체커 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int answer = 0;
		
		for (int tc = 0; tc < T; tc++) {
			String s = sc.next();
			char pre = ' ';
			List<Character> list = new ArrayList<>();
			for (int i = 0; i < s.length(); i++) {
				char ch = s.charAt(i);
				if(!list.contains(ch)) {
					list.add(ch);
					pre = ch;
				}else if(pre != ch) {
					answer--;
					break;
				}
			}
			answer++;
		}
		
		System.out.println(answer);
	}
}
