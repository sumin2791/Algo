class Solution {
    public String solution(String s) {
        s = s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == ' ') {
                s = s.substring(0, i) + s.substring(i, i + 1).toUpperCase() + s.substring(i + 1);
            }
        }

        return s;
    }
}