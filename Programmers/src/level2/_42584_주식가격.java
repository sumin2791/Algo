import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> st = new Stack<>();

        // int pre = 0;

        // for (int i = 0; i < prices.length; i++) {
        // int now = prices[i];
        // if (pre > now || i == prices.length - 1) {
        // int sec = 1;
        // while (st.size() > 0) {
        // int idx = st.pop();
        // answer[idx] = sec;
        // sec++;
        // }
        // }
        // st.push(i);
        // pre = now;
        // }

        for (int i = 0; i < answer.length; i++) {
            int sec = 0;
            for (int j = i + 1; j < answer.length; j++) {
                sec++;
                if (prices[i] > prices[j])
                    break;
            }
            answer[i] = sec;
        }
        answer[prices.length - 1] = 0;
        return answer;
    }
}