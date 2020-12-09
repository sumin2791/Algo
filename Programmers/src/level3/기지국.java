package level3;

import java.util.Scanner;

public class 기지국 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc =  sc.nextInt();
		for (int T = 0; T < tc; T++) {
			int N = sc.nextInt();
			String arr[][] = new String[N][N];
			boolean chk[][] = new boolean[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.next();
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}
		}
		
		
	}
}
