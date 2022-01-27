package baekjoon;

import java.util.Scanner;

public class 세로읽기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int max = 0;
		String[] str_arr = new String[5];
		
		for (int i = 0; i < 5; i++) {
			String s = sc.next();
			max = Math.max(max,s.length());
			str_arr[i] = s;
		}
		
		String[][] sero = new String[5][max];
		for (int i = 0; i < 5; i++) {
			String s = str_arr[i];
			for (int j = 0; j < max; j++) {
				if(j<s.length()) {
					sero[i][j] = s.substring(j,j+1);
				}else {
					sero[i][j] = "@";
				}
			}
		}
		
		String answer = "";
		for (int i = 0; i < max; i++) {
			for (int j = 0; j < 5; j++) {
				if(sero[j][i] != "@") {
					answer += sero[j][i];
				}
			}
		}
		
		System.out.println(answer);
		
	}
}