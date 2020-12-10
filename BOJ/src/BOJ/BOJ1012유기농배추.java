package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class pair{
	int r,c;
	
	pair(int r,int c){
		this.r = r;
		this.c = c;
	}
}


public class BOJ1012유기농배추 {

	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	static int count, N, M;
	static int arr[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			N = sc.nextInt(); //가로
			M = sc.nextInt(); //세로
			arr = new int[N+1][M+1];
			int K = sc.nextInt(); //배추 위치 개수
			count = 0;
		
			for (int i = 0; i < K; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				arr[x][y] = 1;
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					
					if(arr[i][j]==1) {
						dfs(i,j);
						count++;
					}			
				}
			}
			System.out.println(count);
		}
	}

	private static void dfs(int r, int c) {
		arr[r][c] = 2;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(nr>=0 && nr<N && nc>=0 && nc<M && arr[nr][nc]==1) {
				dfs(nr,nc);
			}
		}	
	}
	private static void bfs(int r, int c) {
	      Queue<pair> Q = new LinkedList<>();
//	      visited[r][c] = true;
	      arr[r][c] = 2;
	      Q.offer(new pair(r,c));

	      while(!Q.isEmpty()) {
	         pair p = Q.poll();
//	         int r = p.r;
//	         int c = p.c;

	         for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				if(nr>=0 && nr<N && nc>=0 && nc<M && arr[nr][nc]==1) {
					Q.offer(new pair(nr,nc));
					arr[nr][nc] = 2;
				}
				
			}
	         
	      }
	}
	
}

