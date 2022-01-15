package boj;

import java.util.Scanner;

public class 홀수홀릭호석 {

	public static int min = Integer.MAX_VALUE, max = 0;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int num = sc.nextInt();
        
        getDigit(num,0);
        
        System.out.println(min+" "+max);
    }
	private static void getDigit(int num, int sum) {
		sum += getCnt(num);
		if(num<10) {
			min = Math.min(min,sum);
			max = Math.max(max,sum);
		}else if(num<100) {
			getTwo(num,sum);
		}else {
			getThree(num,sum);
		}
	}
	
	private static int getCnt(int num) {
		int cnt = 0;
		String s = String.valueOf(num);
		for (int i = 0; i < s.length(); i++) {
			if((s.charAt(i)-'0')%2==1) {
				cnt++;
			}
		}
		return cnt;
	}
	private static void getTwo(int num, int sum) {
		getDigit(num/10+num%10,sum);
		
	}
	private static void getThree(int num, int sum) {
		String s = String.valueOf(num);
		for (int i = 1; i < s.length()-1; i++) {
			for (int j = i+1; j < s.length(); j++) {
				String a = s.substring(0,i);
				String b = s.substring(i,j);
				String c = s.substring(j);
				int total = Integer.parseInt(a)+Integer.parseInt(b)+Integer.parseInt(c);
				getDigit(total,sum);
			}
		}
		
		
	}
}
