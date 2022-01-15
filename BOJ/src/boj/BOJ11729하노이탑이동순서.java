package boj;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ11729하노이탑이동순서 {

	static char[][] arr;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
    	arr = new char[N][N];
        for (int i=0; i<N; i++) {
            Arrays.fill(arr[i], ' ');
        }
    	star(0, 0, N);
    	print(arr);
	}

    public static void star(int x, int y, int n) {
    	if(n==1) {
    		arr[x][y] = '*';
    		return ;
    	}
    	
    	for( int i = 0 ; i < 3 ; i ++) {        	
			for( int j = 0 ; j < 3 ; j++) {        		
				if(!(i==1 && j ==1))      			
					star(x+i*(n/3), y+j*(n/3), n/3);   
			}        		
		}    	
    	return ;
    }
   
    public static void print(char[][] arr) {
    	for(int i = 0 ; i < N; i ++) {
    		System.out.println(arr[i]);
    	}
    }
	
}
