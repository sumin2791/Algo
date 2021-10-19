import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(String s) {
        // 가장 밖에 있는 괄호 제거
        s = s.substring(1, s.length() - 1);

        // 튜플 분리 ( a0,a1,a2} 형태임)
        String[] arr = s.split("\\{");
        Map<Integer, String> tuples = new HashMap<>();
        for (String str : arr) {
            // 오른쪽 괄호 제거
            str = str.replace("}", "");
            String[] tuple = str.split(",");
            // map에 해당 튜플의 원소 수, 튜플 문자열 그대로 일단 넣기
            tuples.put(tuple.length, str);
        }

        List<String> numbers = new ArrayList<>();
        for (int i = 1; i <= tuples.size(); i++) {
            // 원소 작은 수대로 튜플 문자열 다시 분해해서 리스트에 숫자 넣어주기
            String tuple = tuples.get(i);
            String[] num = tuple.split(",");
            for (String str : num) {
                if (!numbers.contains(str)) {
                    numbers.add(str);
                }
            }
        }

        int[] answer = new int[numbers.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = Integer.parseInt(numbers.get(i));
        }
        return answer;
    }
}