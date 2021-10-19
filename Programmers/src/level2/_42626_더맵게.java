import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : scoville) {
            pq.add(i);
        }

        while (true) {

            if (pq.size() == 1 && pq.peek() < K) {
                answer = -1;
                break;
            }

            if (Math.min(K, pq.peek()) == K) {
                return answer;
            }

            int one = pq.poll(), two = pq.poll();
            int tmp = one + two * 2;
            pq.add(tmp);
            answer++;

        }

        return answer;
    }
}