package BOJ;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class BOJ2667단지번호붙이기 {

	static int N;
	static int map[][];
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	static int count; //단지 별 개수
	static LinkedList<Integer> q = new LinkedList<Integer>();
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("단지번호붙이기.txt"));
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String s = sc.next();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]==1) {
					count = 0;
					dfs(i,j);
					q.add(count);
				}
			}
		}
		
		System.out.println(q.size());
		q.sort(null);
		for (int i = 0; i < q.size(); i++) {
			System.out.println(q.get(i));
		}
	}
	private static void dfs(int r, int c) {
		map[r][c] = 0;
		count ++;
		
		for (int k = 0; k < 4; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];
			if(nr>=0&&nr<N&&nc>=0&&nc<N&&map[nr][nc]==1) {
				dfs(nr,nc);
			}
		}
	}
}
