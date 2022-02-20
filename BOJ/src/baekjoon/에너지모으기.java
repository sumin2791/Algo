package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 에너지모으기 {
	
	static int energy = 0;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			list.add(sc.nextInt());
		}
		
		getEnergy(list,0);
		
		System.out.println(energy);
	}

	private static void getEnergy(List<Integer> list, int sum) {
		
		if(list.size()==2) {
			energy = Math.max(energy,sum);
			return;
		}
		
		for (int i = 1; i < list.size()-1; i++) {
			int num = list.remove(i);
			getEnergy(list,sum + list.get(i-1)*list.get(i));
			list.add(i,num);
		}
	}
}
