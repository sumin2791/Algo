package baekjoon;

import java.util.Scanner;

public class BOJ2941크로아티아알파벳 {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		String str[] = {"c=", "c-", "dz=", "d=", "lj", "nj", "s=", "z="};
		
		for (int i = 0; i < str.length; i++) {
			s = s.replace(str[i], "a");
		}
		s = s.replace("-", "");
		s = s.replace("=", "");
		
		System.out.println(s.length());
		

	}

}

