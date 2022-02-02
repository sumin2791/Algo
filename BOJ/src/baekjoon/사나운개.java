package baekjoon;

import java.util.Scanner;

public class 사나운개 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A1 = sc.nextInt();
		int B1 = sc.nextInt();
		int A2 = sc.nextInt();
		int B2 = sc.nextInt();
		
		int[] p = new int[3];
		p[0] = sc.nextInt();
		p[1] = sc.nextInt();
		p[2] = sc.nextInt();
		
		for (int i = 0; i < p.length; i++) {
			int ans = 0;
			if(p[i]%(A1+B1)!=0) {
				if(p[i]%(A1+B1)<=A1) {
					ans++;
				}
			}
			if(p[i]%(A2+B2)!=0) {
				if(p[i]%(A2+B2)<=A2) {
					ans++;
				}
			}
			
			System.out.println(ans);
		}
		
	}
}
