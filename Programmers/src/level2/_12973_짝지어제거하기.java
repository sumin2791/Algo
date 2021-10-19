import java.util.Stack;

class Solution {
    public int solution(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (!st.empty() && st.peek() == s.charAt(i)) {
                st.pop();
            } else {
                st.push(s.charAt(i));
            }

        }

        if (st.isEmpty()) {
            return 1;
        } else {
            return 0;
        }

        // while (true) {
        // boolean flag = false;
        // if (s.length() == 0)
        // return 1;

        // if (s.length() == 1)
        // return 0;

        // char pre = s.charAt(0);

        // for (int i = 1; i < s.length(); i++) {
        // if (pre == s.charAt(i)) {
        // s = s.substring(0, i - 1) + s.substring(i + 1);
        // flag = true;
        // break;
        // } else {
        // pre = s.charAt(i);
        // }
        // }

        // if (!flag)
        // return 0;
        // }
    }
}