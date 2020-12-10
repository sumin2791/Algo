package BOJ;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class BOJ2468안전영역 {

	static int N,MAX,cnt;
	static int map[][];
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	static boolean v[][];
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("안전영역.txt"));
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		map = new int[N][N];
		MAX = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for (int h = 0; h < 100; h++) {
			v = new boolean[N][N]; //높이마다 하고나면 다 true되버리니까 초기화해주기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j]==h) {
						map[i][j] = 0;
					}
				}
			} // 높이에 따라 잠기면 0으로 바꿔버리기

			cnt = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j]!=0&&!v[i][j]) {
						
						cnt++;
						bfs(i,j);
						
						
					}
				}
			}

			MAX = Math.max(MAX, cnt);
			
		}
		
		
		System.out.println(MAX);
		
		
	}

	private static void bfs(int r, int c) {
		Queue<Point> Q = new LinkedList();
		Q.add(new Point(r,c));
		v[r][c]=true;
		while(!Q.isEmpty()) {
			Point p = Q.poll();
			for (int k = 0; k < 4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];
				if(nr>=0&&nr<N&&nc>=0&&nc<N && map[nr][nc]!=0&&!v[nr][nc]) {
					v[nr][nc]=true;
					Q.add(new Point(nr, nc));
				}
			}
		}
		
	}
	static class Point{
		int r,c;
		Point(int r,int c){
			this.r=r;
			this.c=c;
		}
	}
	
	private static void dfs(int r, int c) {
		if(v[r][c]) {
			return;
		}
		v[r][c] = true;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr>=0 && nr<N && nc>=0 && nc<N && map[nr][nc]!=0&&!v[nr][nc]) {
				dfs(nr,nc);
			}
		}
	}

	private static void print(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	private static void print(boolean[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}

}
