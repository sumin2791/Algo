package baekjoon;

import java.util.Scanner;

public class 트로피진열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] order = new int[N];
		for (int i = 0; i < order.length; i++) {
			order[i] = sc.nextInt();
		}
		
		int left = 1, right = 1, pre = 0, max = 0;
		
		// left
		pre = order[0];
		for (int i = 1; i < order.length; i++) {
			if(pre < order[i]) {
				left++;
				pre = order[i];
			}
		}
		
		// right
		pre = order[N-1];
		for (int i = N-2; i >=0; i--) {
			if(pre < order[i]) {
				right++;
				pre = order[i];
			}
		}
		
		System.out.println(left);
		System.out.println(right);
	}
}
