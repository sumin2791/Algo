package level3;

public class 최고의집합 {
    public int[] solution(int n, int s) {
        int[] answer = new int [n];
        
        int num=s/n;
        if(num<=0) {
        	answer=new int[1];
        	answer[0]=-1;
        	return answer;
        }
        else {
        	for(int i=0; i<n; i++) {
        		answer[i]=num;
        	}
        	
        	int a=s%n;
        	
        	for(int i=n-1; i>=0; i--) {
        		if(a--<=0) break;
        		answer[i]++;
        	}
        }
        return answer;
    }
}