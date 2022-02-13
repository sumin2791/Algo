package baekjoon;

import java.util.Scanner;

public class 하얀칸 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		char[][] board = new char[8][8];
		
		// input
		for (int i = 0; i < 8; i++) {
			String s = sc.next();
			for (int j = 0; j < 8; j++) {
				board[i][j] = s.charAt(j);
			}
		}
		
		int answer = 0;
		boolean pre = true;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if(pre && board[i][j]=='F') {
					answer ++;
				}
				pre ^= true;
			}
			pre ^= true;
		}
		
		System.out.println(answer);
	}
}
