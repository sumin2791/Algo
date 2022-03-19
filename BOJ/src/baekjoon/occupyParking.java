package baekjoon;

import java.util.Scanner;

public class occupyParking {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] cnt = new int[N];
		
		String yesterday = sc.next();
		String today = sc.next();
		for (int i = 0; i < N; i++) {
			if(yesterday.charAt(i)=='C') {
				cnt[i]++;
			}
			if(today.charAt(i)=='C') {
				cnt[i]++;
			}
		}
		
		int answer = 0;
		for (int i = 0; i < N; i++) {
			if(cnt[i] == 2) {
				answer++;
			}
		}
		
		System.out.println(answer);
	}
}
