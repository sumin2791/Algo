class Solution {
    public int solution(int n) {
        int answer = 0;
        int next = n + 1;
        int two = getOne(n);

        while (n > 0) {
            int n_two = getOne(next);
            if (two == n_two)
                return next;
            next++;
        }

        return answer;
    }

    private int getOne(int n) {
        int cnt = 0;
        String str = Integer.toBinaryString(n);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                cnt++;
            }
        }
        return cnt;
    }
}