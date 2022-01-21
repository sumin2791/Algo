package level3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 이중우선순위큐 {
	public int[] solution(String[] operations) {
		
		List<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < operations.length; i++) {
			String s = operations[i];
			if(s.charAt(0)=='I') {
				list.add(Integer.parseInt(s.substring(2)));
			}else if(s.charAt(2)=='-') {
				if(list.size()!=0) {
					list.remove(0);
				}
			}else {
				if(list.size()!=0) {
					list.remove(list.size()-1);
				}
			}
			Collections.sort(list);
		}
		
        int[] answer = new int[2];
        if(list.size()==0) {
			return answer;
		}
        answer[0] = list.get(list.size()-1);
        answer[1] = list.get(0);
        
        return answer;
    }
}