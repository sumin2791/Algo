class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int zero = 0, cnt = 0;
        while (!s.equals("1")) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    zero++;
                }
            }
            s = s.replace("0", "");
            int len = s.length();
            s = Integer.toBinaryString(len);
            cnt++;
        }
        answer[0] = cnt;
        answer[1] = zero;
        return answer;
    }
}