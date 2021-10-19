class Solution {
    int num, answer;

    public int solution(int[] numbers, int target) {
        answer = 0;
        num = target;

        getTarget(0, 0, numbers);

        return answer;
    }

    private void getTarget(int idx, int sum, int[] numbers) {
        if (idx >= numbers.length) {
            if (sum == num) {
                answer++;
            }
            return;
        }

        getTarget(idx + 1, sum + numbers[idx], numbers);
        getTarget(idx + 1, sum - numbers[idx], numbers);

    }
}