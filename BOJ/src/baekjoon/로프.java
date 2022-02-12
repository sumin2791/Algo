package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class 로프 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int answer = 0;
		
		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			int weight = arr[i] * (arr.length-i);
			answer = Math.max(answer,weight);
		}
		
		System.out.println(answer);
	}
}
