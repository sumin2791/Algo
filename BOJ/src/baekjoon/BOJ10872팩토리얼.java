package baekjoon;

import java.util.Scanner;

public class BOJ10872팩토리얼 {

	static public void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		System.out.println(factorial(N));
		
	}

	private static int factorial(int n) {
		
		if(n<=1) return 1;
		
		return n * factorial(n-1);
		
	}
}
