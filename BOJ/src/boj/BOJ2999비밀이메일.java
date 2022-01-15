package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2999비밀이메일 {
	public static void main(String[] args) {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
		String s = "";
		try {
			s = bf.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		} //String
		String word[] = s.split(""); //데이터 끊어서 배열에 넣음
		
		int N = word.length; //글자수
		int MAX = 0;
		int r = 0;
		int c = 0;

		for (int i = 1; i < N; i++) {
			 if (N % i == 0) {
				 if(i<= N/i) {
	                r = i;
	                c = N/i;
				 }
			}//N을 나누면 나누어 떨어지는 수 중 가장 큰 수 r !!
		}
		String ans[][] = new String[r][c];
		int idx = 0;
		for (int i = 0; i < c; i++) {
			for (int j = 0; j < r; j++) {
				ans[j][i] = word[idx];
				idx++;
			}
		}
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(ans[i][j]);
			}
		}
	}
}
