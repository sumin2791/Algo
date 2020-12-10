package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SWEA2382미생물격리 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 0; t < tc; t++) {
			int N = sc.nextInt(); // 셀 칸 개수
			int M = sc.nextInt(); // 격리 시간
			int K = sc.nextInt(); // 미생물 군집 수
			
			int ans = 0;
			int dr[] = {0, -1, 1, 0, 0};
			int dc[] = {0, 0, 0, -1, 1};
			int info[][] = new int[K][4];
			
			List<Micro> list = new ArrayList<>(); 
			for (int k = 0; k < K; k++) {
				int i = sc.nextInt(); // 세로				
				int j = sc.nextInt(); // 가로				
				int num = sc.nextInt(); // 미생물 개수
				int d = sc.nextInt(); // 상: 1, 하: 2, 좌: 3, 우: 4
				
				Micro micro = new Micro(i,j,num,d,true);
				list.add(micro);
				
			} // 입력 끝 
			
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < list.size(); j++) {
					Micro m = list.get(j);
					if(m.isOk) {
						int nr = m.i + dr[m.d];
						int nc = m.j + dc[m.d];
						m.i = nr;
						m.j = nc;
					}
				}
				
				for (int j = 0; j < list.size(); j++) {
					Micro m = list.get(j);
					if(m.i==0||m.i==N-1||m.j==0||m.j==N-1) {
						m.num /= 2;
						if(m.d==1) {
							m.d = 2;
						}else if(m.d==2) {
							m.d = 1;
						}else if(m.d==3) {
							m.d = 4;
						}else if(m.d==4) {
							m.d = 3;
						}
						if(m.num<=0) {
							m.isOk = false;
						}
					}else {
						int max = m.num;
						for (int l = j+1; l < list.size(); l++) {
							Micro m2 = list.get(l);
							if(m.i==m2.i&&m.j==m2.j&&m.isOk&&m2.isOk) {
								if(max>m2.num) {
									m.num += m2.num;
									m2.isOk = false;
								}else {
									max = m2.num;
									m2.num += m.num;
									m.isOk = false;
									break;
								}
							}
						}
					}
				}
				
			}
			
			for (int i = 0; i < list.size(); i++) {
				Micro sum = list.get(i);
				if(sum.isOk) {
					ans += sum.num;
				}
			}
			
			System.out.println("#"+(t+1)+" "+ans);
		}
	}
	
	static class Micro{
		int i, j , num, d;
		boolean isOk;
		
		Micro(int i, int j, int num, int d, boolean isOk){
			this.i = i;
			this.j = j;
			this.num = num;
			this.d = d;
			this.isOk = isOk;
		}
	}
}
