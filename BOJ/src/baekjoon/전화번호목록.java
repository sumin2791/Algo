package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class 전화번호목록 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			if(n==1) {
				int a = sc.nextInt();
				System.out.println("YES");
			}else {
				String[] arr = new String[n];
				for (int j = 0; j < n; j++) {
					arr[j] = sc.next();
				}
				Arrays.sort(arr);
				String ans = isSuffix(arr);
				System.out.println(ans);
			}
			
		}
	}

	private static String isSuffix(String[] arr) {
		for (int i = 0; i < arr.length-2; i++) {
			
			if(arr[i].length() != arr[i+1].length() && arr[i+1].substring(0,arr[i].length()).equals(arr[i])){
				return "NO";
			}
		}
		
		return "YES";
	}
}
