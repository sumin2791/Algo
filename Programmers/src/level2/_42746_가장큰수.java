import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";

        List<String> list = new ArrayList<>();
        for (int i : numbers) {
            list.add(Integer.toString(i));
        }

        // Collections.sort(list);

        Collections.sort(list, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {

                return ((o2 + o1).compareTo(o1 + o2));
            }
        });

        for (String string : list) {
            answer += string;
        }

        if (answer.charAt(0) == '0') {
            return "0";
        }

        return answer;
    }
}