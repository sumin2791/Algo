class Solution {
    public String solution(int n) {
        String answer = "";

        while (n > 0) {
            n -= 1;

            int tmp = n % 3 == 0 ? 1 : (n % 3 == 1 ? 2 : 4);
            n /= 3;

            answer = Integer.toString(tmp) + answer;
        }

        return answer;
    }
}