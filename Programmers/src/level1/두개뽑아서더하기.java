package level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class 두개뽑아서더하기 {
	public static void main(String[] args) {
		int[] numbers = {2,1,3,4,1}; 
		solution(numbers);
	}
	
	static public int[] solution(int[] numbers) {
        HashSet<Integer> hash = new HashSet<Integer>();
        
        for(int i=0; i<numbers.length; i++){
            for(int j=i; j<numbers.length; j++){
                int a = numbers[i] + numbers[j];
                hash.add(a);
            }
        }
        
        List<Integer> list = new ArrayList<Integer>(hash);
        Collections.sort(list);
        
        int[] answer = new int[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
        
        return answer;
    }
}