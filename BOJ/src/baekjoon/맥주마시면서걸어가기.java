package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 맥주마시면서걸어가기 {

	static class Convinient{
		int r,c;
		Convinient(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int n = sc.nextInt(); 
			boolean mood = false;
			boolean v[] = new boolean[n];

			int hr = sc.nextInt();
			int hc = sc.nextInt();
			
			Convinient[] list = new Convinient[n];
			for (int i = 0; i < n; i++) {
				int cr = sc.nextInt();
				int cc = sc.nextInt();
				list[i] = new Convinient(cr,cc);
			}
			
			int rr = sc.nextInt();
			int rc = sc.nextInt();
			
			Queue<Convinient> q = new LinkedList<Convinient>();
			q.add(new Convinient(hr,hc));
			
			while(!q.isEmpty()) {
				Convinient con = q.poll();
				if(Math.abs(con.r-rr)+
						Math.abs(con.c-rc)<=1000) {
					mood = true;
					break;
				}
				
				for (int i = 0; i < list.length; i++) {
					if(!v[i]&&Math.abs(con.r-list[i].r)+
							Math.abs(con.c-list[i].c)<=1000){
						q.add(list[i]);
                        v[i] = true;
							}
				}
			}
			if(mood) System.out.println("happy");
			else System.out.println("sad");		
			
		}
	}
}
