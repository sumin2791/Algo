package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 카드2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 1; i <= n; i++) {
			queue.add(i);
		}
		
		while(queue.size()>1) {
			queue.poll();
			int a = queue.poll();
			queue.add(a);
		}
		
		System.out.println(queue.poll());
	}
}
