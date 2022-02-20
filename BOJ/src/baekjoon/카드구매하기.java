package baekjoon;

import java.util.Scanner;

public class 카드구매하기 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] card = new int[N+1], dp = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			card[i] = sc.nextInt();
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i] = Math.max(dp[i],(dp[i-j]+card[j]));
			}
		}
		
		
		System.out.println(dp[N]);
	}

//	private static void getCard(int[] card, int n, int total) {
//		if(n==0) {
//			ans = Math.max(ans,total);
//			return;
//		}
//		
//		for (int i = 1; i <= card.length; i++) {
//			if(n >= i) {
//				getCard(card, n - i, total + card[i-1]);
//			}
//		}
//		
//		return;
//		
//	}
}
