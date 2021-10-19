import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<String> list = new ArrayList<>();

    public int[] solution(String msg) {
        List<Integer> ans = new ArrayList<>();
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String[] abc = s.split("");
        for (int i = 0; i < abc.length; i++) {
            list.add(abc[i]);
        }

        while (msg.length() > 0) {
            // 최대 문자열 찾기
            int cnt = find(msg, 1);
            String str = msg.substring(0, cnt);

            // 인덱스 찾아서 답에 넣기
            ans.add(list.indexOf(str) + 1);

            // 처리되지 않은 글자 사전에 넣기
            if (msg.length() > cnt) {
                list.add(msg.substring(0, cnt + 1));
            }

            // 최대 문자열 제거
            if (msg.length() == cnt)
                break;
            msg = msg.substring(cnt);
        }
        int[] answer = new int[ans.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = ans.get(i);
        }
        return answer;
    }

    private int find(String msg, int i) {
        if (msg.length() < i)
            return i - 1;
        String s = msg.substring(0, i);
        if (list.contains(s)) {
            return find(msg, i + 1);
        } else {
            return i - 1;
        }
    }
}