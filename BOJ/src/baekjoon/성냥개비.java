package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 성냥개비 {
	static int[] matches = {6,2,5,5,4,5,6,3,7,6};
	static long min, max;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		for (int i = 0; i < tc; i++) {
			int match = sc.nextInt();
			min = Integer.MAX_VALUE;
			max = 0;
			List<Integer> numList = new ArrayList<>();
			getNumber(match,numList);
			System.out.println("answer: "+min+" "+max);
		}
	}
	private static void getNumber(int match, List<Integer> numList) {
		if(match == 0) {
//			for (int i = 0; i < numList.size(); i++) {
//				System.out.print(numList.get(i)+" ");
//			}
//			System.out.println();
			getCombi(numList,"",new boolean[numList.size()]);
		}
		
		if(match < 2) {
			return;
		}
		
		for (int i = 0; i < matches.length; i++) {
			if(match >= matches[i]) {
				numList.add(0,i);
				getNumber(match-matches[i],numList);
				numList.remove(0);
			}
		}
	}
	private static void getCombi(List<Integer> numList, String str, boolean[] v) {
		if(numList.size()==str.length()) {
			if(str.charAt(0)=='0') {
				return;
			}

			long num = Long.parseLong(str);
			min = Math.min(min,num);
			max = Math.max(max,num);
//			System.out.println("num: "+num+" min: "+min+" max: "+max);
			return;
		}
		
		for (int i = 0; i < v.length; i++) {
			if(!v[i]) {
				v[i] = true;
				int n = numList.get(i);
				str += Integer.toString(n);
				getCombi(numList,str,v);
//				v[i] = false;
			}
		}
	}
}

// 메모리 초과
