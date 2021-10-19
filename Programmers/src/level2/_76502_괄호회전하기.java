import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;

        if (s.length() % 2 == 1)
            return 0;

        for (int i = 0; i < s.length(); i++) {
            Stack<Character> open = new Stack<>();
            boolean flag = true;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '(' || s.charAt(j) == '{' || s.charAt(j) == '[') {
                    open.push(s.charAt(j));
                } else if (open.size() == 0) {
                    flag = false;
                    break;
                } else {
                    char pre = open.pop();
                    if (s.charAt(j) == ')' && pre == '(') {
                        continue;
                    } else if (s.charAt(j) == '}' && pre == '{') {
                        continue;
                    } else if (s.charAt(j) == ']' && pre == '[') {
                        continue;
                    } else {
                        flag = false;
                        break;
                    }
                }
            }

            if (flag) {
                answer++;
            }

            String first = s.substring(0, 1);
            s = s.substring(1).concat(first);
        }
        return answer;
    }
}