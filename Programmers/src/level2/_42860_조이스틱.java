class Solution {
    public int solution(String name) {
        int answer = 0, min = name.length() - 1;
        boolean[] chk = new boolean[name.length()];

        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) != 'A') {
                if (name.charAt(i) <= 'N') {
                    answer += 13 - ('N' - name.charAt(i));
                } else {
                    answer += 1 + 'Z' - name.charAt(i);
                }
                if (i != name.length() - 1) {
                    answer++;
                }
            } else {
                int cnt = 1;
                int idx = i + 1;
                while (name.charAt(idx) == 'A') {
                    cnt++;
                    idx++;
                }

                min = Math.min(min, name.length() - cnt - 1 + i - 2);
                answer += min;
                i += cnt - 1;
            }
        }

        return answer;
    }
}