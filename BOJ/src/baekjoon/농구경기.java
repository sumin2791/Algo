package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class 농구경기 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		HashMap<String,Integer> map = new HashMap<>();
		
		for (int i = 0; i < tc; i++) {
			String name = sc.next();
			String first = name.substring(0,1);			
			int cnt = 1;
			if(map.containsKey(first)) {
				cnt += map.get(first);				
			}
			map.put(first,cnt);
		}
		
		ArrayList<String> list = new ArrayList<>();
		
		for (HashMap.Entry<String, Integer> entry : map.entrySet()) {
			if(entry.getValue() >= 5) {
				list.add(entry.getKey());
			}
		}
		
		if(list.size() == 0) {
			System.out.println("PREDAJA");
		}else {
			String answer = "";
			Collections.sort(list);
			for (int i = 0; i < list.size(); i++) {
				answer += list.get(i);
			}
			System.out.println(answer);
		}
	}
}
