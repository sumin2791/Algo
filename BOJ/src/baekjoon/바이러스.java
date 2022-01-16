package baekjoon;

import java.util.Scanner;

public class 바이러스 {

	static int cnt = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int E = sc.nextInt();
		
		int[][] graph = new int[N+1][N+1];
		boolean[] v = new boolean[N+1];
		for (int i = 0; i < E; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph[a][b] = 1;
			graph[b][a] = 1;
		}
		
		dfs(graph,v,1);
		
		System.out.println(cnt-1);
	}

	private static void dfs(int[][] graph, boolean[] v, int idx) {
		if(v[idx]) {
			return;
		}
		
		v[idx] = true;
		cnt++;
		
		for (int i = 0; i < v.length; i++) {
			if(graph[idx][i]==1&&!v[i]) {
				dfs(graph,v,i);
			}
		}
		
	}
}
