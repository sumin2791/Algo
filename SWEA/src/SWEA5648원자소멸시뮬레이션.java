

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SWEA5648원자소멸시뮬레이션 {

	static int N,X,Y,D,K,Ans;
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static int map[][] = new int[4002][4002];
	static ArrayList<Atom> list;
	static boolean flag = true;
	static class Atom{
		int r,c,d,k,idx;
		Atom(int r, int c, int d, int k, int idx){
			this.r = r;
			this.c = c;
			this.d = d;
			this.k = k;
			this.idx = idx;
		}
	}
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("원자 소멸 시뮬레이션.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			list = new ArrayList<Atom>();
			N = sc.nextInt();
			for (int n = 0; n < N; n++) {
				int r = (sc.nextInt()+1000)*2;
				int c = (sc.nextInt()+1000)*2;
				int d = sc.nextInt();
				int k = sc.nextInt();
				map[r][c] = 1;
				list.add(new Atom(r,c,d,k,1));
			}
//			for (Atom atom : list) {
//				System.out.println(atom.r+" "+atom.c+" "+atom.d+" "+atom.k);
//			}
			while(flag) {
				
				simulation();
				cnt();
			}
			System.out.println("#"+tc+" "+Ans);
		}
	}
	private static void simulation() {
//		int N = list.size();
//		for (Atom atom : list) {
//			if(atom.idx==0) N--;
//		}
//		if(N<=1) {
//			flag = false;
//		}
		for (int i = 0; i < list.size(); i++) {
			Atom atom = list.get(i);
			int nr = atom.r + dr[atom.d];
			int nc = atom.c + dc[atom.d];
			if(nr>=0&&nr<4002&&nc>=0&&nc<4002&&atom.idx==1) {
				map[nr][nc]++;
				map[atom.r][atom.c] -- ;
				atom.r = nr;
				atom.c = nc;
//				System.out.println("nr "+nr+" nc"+nc);
			}else {
				map[atom.r][atom.c] --;
				System.out.println(atom.r + " "+atom.c);
//				list.remove(i);
				atom.idx = 0;
			}
		}
		
	}
	private static void cnt() {
		int N = list.size();
		for (Atom atom : list) {
			if(atom.idx==0) N--;
		}
		if(N<=1) {
			flag = false;
			return;
		}
		
		for (int i = 0; i < list.size(); i++) {
			Atom atom = list.get(i);
			if(map[atom.r][atom.c]>=2) {
				System.out.println(atom.r+" "+atom.c);
				for (int j = 0; j < list.size(); j++) {
					Atom atom2 = list.get(j);
					if(i!=j&&atom.r==atom2.r&&atom.c==atom2.c) {
						Ans += atom2.k;
						map[atom2.r][atom2.c] --;
//						list.remove(j);
						atom2.idx = 0;
					}
				}
				Ans += atom.k;
				map[atom.r][atom.c] --;
//				list.remove(i);
				atom.idx = 0;
			}
		}
		
	}
}
