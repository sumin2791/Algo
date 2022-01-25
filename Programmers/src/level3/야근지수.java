package level3;

import java.util.Collections;
import java.util.PriorityQueue;

public class 야근지수 {
    public long solution(int n, int[] works) {
    	
    	PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    	
    	for (int i = 0; i < works.length; i++) {
			pq.offer(works[i]);
		}
    	
    	while(n>0) {
    		int max = pq.poll();
    		pq.offer(max-1);
    		n--;
    	}
    	
        long answer = 0;
        while(pq.size()>0) {
        	int num = pq.poll();
        	if(num>0) {
        		answer += num * num;	
        	}
        }
        
        return answer;
    }
}
