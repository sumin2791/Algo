class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i = n; i > 0; i--) {
            if (num(i, n)) {
                answer++;
            }
        }
        return answer;
    }

    private boolean num(int i, int n) {
        int sum = 0;
        for (int j = i; j >= 0; j--) {
            if (sum == n)
                return true;
            if (sum > n)
                return false;
            sum += j;
        }
        return false;
    }
}