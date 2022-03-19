package baekjoon;

import java.util.Scanner;

public class Esepresso {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int S = sc.nextInt();
		int cnt = 0, water = 0, tank = S;
		
		for (int i = 0; i < N; i++) {
			 String s = sc.next();
			 if(s.contains("L")) {
				 s = s.substring(0,s.length()-1);
				 water = Integer.parseInt(s)+1;
			 }else {
				 water = Integer.parseInt(s);
			 }

			 if(tank >= water) {
				 tank -= water;
			 }else {
				 cnt++;
				 tank = S - water; 
			 }
		}
		
		System.out.println(cnt);
	}
}
