package BOJ;

import java.util.Scanner;

public class BOJ10870피보나치수5 {

	static public void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		System.out.println(fibonacci(N));
		
	}

	private static int fibonacci(int n) {
		
		if(n<=1) return n;
		
		return fibonacci(n-1) + fibonacci(n-2);
		
	}
}
