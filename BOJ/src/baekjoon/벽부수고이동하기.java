package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 벽부수고이동하기 {
	
	static int N,M,Ans=Integer.MAX_VALUE;
	static int [][] map;
	static boolean[][][] v;
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		map=new int[N+1][M+1];
		v=new boolean[N+1][M+1][2];
		for (int r = 1; r <= N; r++) {
			String input = sc.next();
			for (int c = 1; c <= M; c++) {
				map[r][c]=input.charAt(c-1)-'0';
			}
		}

		bfs();
		if(Ans == Integer.MAX_VALUE) Ans = -1;   
        System.out.println(Ans);
	}
	static class Point{
		int r,c,cnt,chk;
		public Point(int r, int c, int cnt, int chk) {
	        super();
	        this.r = r;
	        this.c = c;
	        this.cnt = cnt;
	        this.chk = chk;
	    }
	}
	
	private static void bfs() {
		Queue<Point> Q = new LinkedList<Point>();
		Q.add(new Point(1, 1, 1, 0));
		v[1][1][0]=true;
		while(!Q.isEmpty()) {
			Point p = Q.poll();
			if(p.r==N&&p.c==M) {
				// 도작점 도달
				Ans = Math.min(Ans, p.cnt);
			}
			for (int k = 0; k < 4; k++) {
				int nr = p.r+dr[k];
				int nc = p.c+dc[k];
				if(nr>=1 && nr <= N && nc>=1 && nc <= M) {
					if(p.chk==1) {
						if(map[nr][nc]==0&&!v[nr][nc][p.chk]) {
							Q.add(new Point(nr, nc, p.cnt+1,p.chk));
							v[nr][nc][p.chk]=true;
						}
					}else {
						if(map[nr][nc]==1&&!v[nr][nc][p.chk]) {
							Q.add(new Point(nr, nc, p.cnt+1,p.chk+1));
							v[nr][nc][p.chk+1]=true;
						}else if(map[nr][nc]==0&&!v[nr][nc][p.chk]) {
							Q.add(new Point(nr, nc, p.cnt+1,p.chk));
							v[nr][nc][p.chk]=true;
						}
					}	
				
				}
			}
		}
	}
	
//	static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
//	static int N,M,answer;
//	static int[][] board;
//	
//	public static void main(String[] args) {
//		
//		Scanner sc = new Scanner(System.in);
//		
//		answer = Integer.MAX_VALUE;
//		N = sc.nextInt();
//		M = sc.nextInt();
//		board = new int[N][M];
//		
//		for (int i = 0; i < N; i++) {
//			String s = sc.next();
//			for (int j = 0; j < M; j++) {
//				board[i][j] = s.charAt(j) - '0';
//			}
//		}
//		
//		move(0,0,0,false,new boolean[N][M]);
//		
//		if(answer != Integer.MAX_VALUE) {
//			System.out.println(answer);
//		}else {
//			System.out.println(-1);
//		}
//
//	}
//
//	private static void move(int r, int c, int cnt, boolean chk, boolean[][] v) {
//		
//		if(r==0 && c==0) {
//			v[0][0] = true;
//		}
//		cnt ++;
//		
//		if(r == N-1 && c == M-1) {
//			answer = Math.min(answer,cnt);
//			return;
//		}
//		
//		for (int d = 0; d < 4; d++) {
//			int nr = r + dr[d];
//			int nc = c + dc[d];
//			
//			if(nr >= 0 && nc >= 0 && nr < N && nc < M) {
//				// 벽 없는 경우
//				if(board[nr][nc]==0 && !v[nr][nc]) {
//					v[nr][nc] = true;
//					move(nr,nc,cnt,chk,v);
//					v[nr][nc] = false;
//				}
//				// 벽 있지만 부수는 경우
//				else if(!chk && !v[nr][nc]) {
//					v[nr][nc] = true;
//					move(nr,nc,cnt,true,v);
//					v[nr][nc] = false;
//				}
//			}
//		}
//	}

}