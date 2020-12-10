package BOJ;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BOJ2847게임을만든동준이 {

	static int arr[];
	static int idx;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("게임을 만든 동준이.txt"));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}	
		level(N-1); // 맨 뒤부터 확인
		System.out.println(idx);
	}

	private static void level(int n) {
		if(n==0) return;
		if(arr[n-1]>=arr[n]) { // 쉬운 난이도가 더 큰 경우
			idx += arr[n-1] - arr[n] + 1; // 감소한만큼 idx에 더하기
			arr[n-1] = arr[n]-1; // 바로 뒤의 난이도의 점수 -1
		}
		level(n-1);
	}
}
