import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution {
    Map<String, Integer> menuMap = new HashMap<>();
    List<String> ans = new ArrayList<>();
    Map<Character, Integer> map = new HashMap<>();
    List<Character> list = new ArrayList<>();

    public String[] solution(String[] orders, int[] course) {
        // 카운트 담긴 맵, 메뉴들만 담긴 리스트
        for (String order : orders) {
            for (int i = 0; i < order.length(); i++) {
                char c = order.charAt(i);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else {
                    map.put(c, 1);
                    list.add(c);
                }
            }
        }

        // 2 미만은 아예 삭제
        for (int i = 0; i < list.size(); i++) {
            if (map.get(list.get(i)) <= 1) {
                map.remove(list.get(i));
                list.remove(i);
                i--;
            }
        }

        for (int i = 0; i < course.length; i++) {
            menuMap.clear();
            // 일단 개수별로 조합 먼저 구함
            combi(course[i], new boolean[list.size()], "", 0);

            // 조합의 최댓값 구하기
            int max = 0;
            for (String key : menuMap.keySet()) {
                max = Math.max(max, menuMap.get(key));
            }

            // 최대인 조합 정답리스트에 넣기
            for (String key : menuMap.keySet()) {
                if (menuMap.get(key) == max) {
                    ans.add(key);
                }
            }
        }

        String[] answer = new String[ans.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = ans.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }

    private void combi(int cnt, boolean[] v, String menu, int sum) {
        if (menu.length() == cnt) {
            menuMap.put(menu, sum);
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            if (!v[i]) {
                v[i] = true;
                menu = menu.concat(Character.toString(list.get(i)));
                sum += map.get(list.get(i));
                combi(cnt, v, menu, sum);
            }
        }
    }
}