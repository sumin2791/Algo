package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 달이차오른다가자 {

	static class Point{
		int r,c,key,cnt;

		public Point(int r, int c, int key, int cnt) {
			this.r = r;
			this.c = c;
			this.key = key;
			this.cnt = cnt;
		}	
	}
	static int N,M,Ans;
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static char[][] maze;
	static boolean[][][] v;
	static Point start;
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("input/달이차오른다.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 가로
		maze = new char[N][M];
		v = new boolean[N][M][2<<6];
		for (int i = 0; i < N; i++) {
			maze[i] = br.readLine().toCharArray();
			// maze 구성 끝
			for (int j = 0; j < M; j++) {
				// find start
				if(maze[i][j]=='0') {
					start = new Point(i,j,0,0);
					v[i][j][0]=true;
				}
			}
		}
		
		//print(maze);
		
		Ans = bfs();
		System.out.println(Ans);
	}

	private static int bfs() {
		Queue<Point> q = new LinkedList<>();
		q.add(start);
		while(!q.isEmpty()) {
			Point p = q.poll();
			if(maze[p.r][p.c]=='1') {
				return p.cnt;
			}
			
			for (int d = 0; d < 4; d++) {
				int nr = p.r+dr[d];
				int nc = p.c+dc[d];
				int K = p.key;
				// 범위&벽 체크
				if(!check(nr,nc)) continue;
				if(maze[nr][nc]=='#') continue;
				// 열쇠 만나면 비트마스킹
				if('a'<=maze[nr][nc]&&'f'>=maze[nr][nc]) {
					// 1과 OR 연산 하면 반드시 1이 나오니까 maze[nr][nc]가 켜지는 것....
					K |= (1<<(maze[nr][nc]-'a'));
				}
				// 문 만남
				if('A'<=maze[nr][nc]&&'F'>=maze[nr][nc]) {
					// 열쇠가 없는 경우
					if((K & (1<<(maze[nr][nc]-'A')))==0) continue;
				}
				
				// 이미 방문했던 경우
				if(v[nr][nc][K]) continue;
				
				v[nr][nc][K] = true;
				q.add(new Point(nr,nc,K,p.cnt+1));
			}
			
		}
		return -1;
	}
	
	
	private static boolean check(int nr, int nc) {
		if(nr>=0&&nr<N&&nc>=0&&nc<M) return true;
		return false;
	}

	private static void print(char[][] maze) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(maze[i][j]+" ");
			}
			System.out.println();
		}
	}

}
