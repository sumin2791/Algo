class Solution {
    int answer = 0;
    String[] names = { "A", "C", "F", "J", "M", "N", "R", "T" };
    String[] info;

    public int solution(int n, String[] data) {
        info = data;
        getP("", new boolean[8]);
        return answer;
    }

    private void getP(String line, boolean[] v) {
        if (line.length() == 8) {
            check(line);
            return;
        }

        for (int i = 0; i < 8; i++) {
            if (!v[i]) {
                v[i] = true;
                getP(line + names[i], v);
                v[i] = false;
            }
        }
    }

    private void check(String line) {
        for (String data : info) {
            int one = line.indexOf(data.charAt(0));
            int two = line.indexOf(data.charAt(2));
            int diff = Math.abs(one - two);
            int num = data.charAt(4) - '0' + 1;
            char ch = data.charAt(3);

            if (ch == '<') {
                if (diff >= num) {
                    return;
                }
            } else if (ch == '>') {
                if (diff <= num) {
                    return;
                }
            } else if (ch == '=') {
                if (diff != num) {
                    return;
                }
            }
        }
        answer++;
    }
}