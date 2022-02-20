package baekjoon;

import java.util.Scanner;

public class 손익분기점 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt(), B = sc.nextInt(), C = sc.nextInt();
		
		if(B >= C) {
			System.out.println(-1);
			return;
		}	
		
		System.out.println((A/(C-B))+1);
	}
}
