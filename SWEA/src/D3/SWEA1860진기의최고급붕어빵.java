package D3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class SWEA1860진기의최고급붕어빵 {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("진기의 최고급 붕어빵.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			boolean ans = true;
			int time[] = new int[N];
			for (int i = 0; i < N; i++) {
				time[i] = sc.nextInt();
			}
			Arrays.sort(time);
			int cnt = 0;
			int minus = 0;
			for (int i = 0; i < N; i++) {
				cnt = (time[i]/M)*K + minus;
				if(cnt>0) {
					minus --;
				}else {
					ans = false;
					break;
				}
			}
			
			if(ans) {
				System.out.println("#"+tc+" Possible");
			}else {
				System.out.println("#"+tc+" Impossible");
			}
		}
	}
}
