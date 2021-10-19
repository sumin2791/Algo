class Solution {
    public static int solution(String s) {
        if (s.length() == 1) {
            return 1;
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= s.length() / 2; i++) {
            String a, b = "";
            String result = "";
            int cnt = 1;
            for (int j = 0; j <= s.length() / i; j++) {
                int start = j * i;
                int end = i * (j + 1) > s.length() ? s.length() : i * (j + 1);
                a = b;
                b = s.substring(start, end);

                if (a.equals(b)) {
                    cnt++;
                } else {
                    result += (getCnt(cnt) + a);
                    cnt = 1;
                }
            }
            result += (getCnt(cnt) + b);
            answer = Math.min(answer, result.length());
        }

        return answer;
    }

    private static String getCnt(int cnt) {
        return cnt > 1 ? Integer.toString(cnt) : "";
    }
}