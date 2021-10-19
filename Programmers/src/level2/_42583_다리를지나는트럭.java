import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = bridge_length, sum = 0, cnt = 0;
        Queue bridge = new LinkedList<>();
        // sum: 현재 다리 위 무게, cnt: 트럭 카운트, bridge: 현재 다리 상태

        while (true) {
            if (cnt == truck_weights.length)
                break;
            if (bridge.size() == bridge_length) { // 다리 위 꽉찬 경우
                sum -= (int) bridge.poll();
            } else if (sum + truck_weights[cnt] > weight) {
                bridge.offer(0);
                answer++;
            } else {
                bridge.offer(truck_weights[cnt]);
                sum += truck_weights[cnt];
                answer++;
                cnt++;
            }
        }
        return answer;
    }
}