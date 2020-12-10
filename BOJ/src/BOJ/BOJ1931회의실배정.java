package BOJ;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BOJ1931회의실배정 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("회의실배정.txt"));
		Scanner sc = new Scanner(System.in);
		
		class Room implements Comparable<Room>{
			int start, end;
			Room(int start, int end){
				this.start = start;
				this.end = end;
			}
			@Override
			public int compareTo(Room o) {
				int time = this.end - o.end;
		        if(time!=0)
		            return time;
		        return this.start - o.start;
			}
		}
		
		int N = sc.nextInt();
		ArrayList<Room> rooms = new ArrayList();
		for (int i = 0; i < N; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			rooms.add(new Room(start, end));
		}
		
		Collections.sort(rooms);
		
		int cnt = 1;
        Room first = rooms.get(0);
        int end = first.end;
        for (int i = 1; i < N; i++) {
			Room room = rooms.get(i);
			if(room.start>=end) {
				cnt++;
				end = room.end;
			}
		}
        
        System.out.println(cnt);

	}

}
