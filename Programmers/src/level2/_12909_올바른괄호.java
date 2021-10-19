class Solution {
    boolean solution(String s) {
        if (s.length() % 2 != 0)
            return false;

        int open = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (open == 0) {
                    return false;
                } else {
                    open--;
                }
            } else {
                open++;
            }
        }
        if (open != 0)
            return false;
        return true;
    }
}