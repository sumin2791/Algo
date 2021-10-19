import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        Map<List<String>, Integer> map = new HashMap<>();
        for (int i = 0; i < info.length; i++) {
            String[] list = info[i].split(" ");
            List<String> str = new ArrayList<>();
            int score = 0;
            for (int j = 0; j < list.length; j++) {

                if (j == list.length - 1) {
                    score = Integer.parseInt(list[j]);
                } else {
                    str.add(list[j]);
                }
            }

            map.put(str, score);
        }
        for (int i = 0; i < query.length; i++) {
            String[] search = query[i].split(" and ");
            String[] tmp = search[3].split(" ");
            search[3] = tmp[0];
            int score = Integer.parseInt(tmp[1]);

            for (String string : info) {
                if ((search[0].equals("-") || string.contains(search[0]))
                        && (search[1].equals("-") || string.contains(search[1]))
                        && (search[2].equals("-") || string.contains(search[2]))
                        && (search[3].equals("-") || string.contains(search[3]))) {
                    String[] infos = string.split(" ");
                    int info_score = Integer.parseInt(infos[4]);
                    if (info_score >= score) {
                        answer[i]++;
                    }
                }
            }
        }

        return answer;
    }
}
