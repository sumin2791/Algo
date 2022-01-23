package level1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class 신고결과받기 {
	public int[] solution(String[] id_list, String[] report_list, int k) {
		Map<String,Integer> reportMap = new HashMap<>();
		Map<String,HashSet<String>> userMap = new HashMap<>();
		
		for (int i = 0; i < report_list.length; i++) {
			String[] report = report_list[i].split(" ");
			
			// 신고자의 피신고자 목록
			HashSet<String> userSet = new HashSet<>();
			if (userMap.containsKey(report[0])) {
				userSet = userMap.get(report[0]);
				if(userSet.contains(report[1])) {
					continue;
				}
			}
			userSet.add(report[1]);
			userMap.put(report[0], userSet);
						
			// 피신고자 카운트
			int cnt = 0;
			if(reportMap.containsKey(report[1])) {
				cnt = reportMap.get(report[1]);
			}
			reportMap.put(report[1],cnt+1);
			
		}
		
		int[] answer = new int[id_list.length];
		for (int i = 0; i < id_list.length; i++) {
			String user_id =  id_list[i];
			if(userMap.containsKey(user_id)) {
				HashSet<String> userSet = userMap.get(user_id);
				
				Iterator<String> iter = userSet.iterator();
				while(iter.hasNext()) {
					String black_id = iter.next();
					if(reportMap.containsKey(black_id) && reportMap.get(black_id) >= k) {
						answer[i]++;
					}
				}
			}	
		}
		  
        return answer;
    }
}
