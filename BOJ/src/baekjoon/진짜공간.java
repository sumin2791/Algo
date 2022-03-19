package baekjoon;

import java.util.Scanner;

public class 진짜공간 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] files = new int[n];
		for (int i = 0; i < files.length; i++) {
			files[i] = sc.nextInt();
		}
		int size = sc.nextInt();
		
		long cnt = 0;
		for (int i = 0; i < files.length; i++) {
			cnt += Math.ceil((double)files[i]/size);
		}
		
		System.out.println(cnt*size);
	}
}
