class Solution {
    public String solution(int n, int t, int m, int p) {
        int len = m * (t - 1) + p;
        String s = "";
        int num = 0;

        while (s.length() < len) {
            s += Integer.toString(num, n).toUpperCase();
            num++;
        }
        System.out.println(s);

        String answer = "";
        int idx = 0;
        while (true) {
            answer += s.charAt(idx * m + p - 1);
            idx++;
            if (idx == t)
                break;
        }
        return answer;
    }
}