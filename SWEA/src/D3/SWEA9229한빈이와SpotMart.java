package D3;

import java.util.Scanner;

public class SWEA9229한빈이와SpotMart {

	static int arr[];
	static int sel[] = new int[2];
	static int max;
	static int sum;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for (int t = 0; t < TC; t++) {
			int N = sc.nextInt(); //과자봉지 개수
			int M = sc.nextInt(); //무게 합 제한
			arr = new int[N];
			max = -1;
			
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			
			combination(0,0,M);
			
			System.out.println("#"+(t+1)+" "+max);
		}
	}

	private static void combination(int idx, int k, int M) {
		
		sum = 0;
		// 다 뽑은 경우
		if(k==sel.length) {
			sum += sel[0] + sel[1];
			if(sum<=M&&sum>max) {
				max = sum;
			}
			return;
		}				
		// 더 뽑을것이 없는 경우
		if(idx==arr.length) {
			return;
		}
				
		// 뽑기
		sel[k] = arr[idx];
		//뽑는 경우				
		combination(idx+1, k+1, M);
		// 안뽑는 경우 idx만 증가시키고 k값을 그대로 두면 sel에 안 들어감
		combination(idx+1, k, M);
		
	}

}
