import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (String string : record) {
            String[] msg = string.split(" ");
            if (msg[0].equals("Enter")) {
                map.put(msg[1], msg[2]);
                list.add("E".concat(msg[1]));
            } else if (msg[0].equals("Leave")) {
                list.add("L".concat(msg[1]));
            } else if (msg[0].equals("Change")) {
                map.put(msg[1], msg[2]);
            }
        }

        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            String msg = list.get(i);
            String nick = map.get(msg.substring(1));
            if (msg.charAt(0) == 'E') {
                answer[i] = nick.concat("님이 들어왔습니다.");
            } else {
                answer[i] = nick.concat("님이 나갔습니다.");
            }
        }
        return answer;
    }
}