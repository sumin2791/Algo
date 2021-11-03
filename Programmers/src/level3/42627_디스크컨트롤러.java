import java.util.List;
import java.util.Comparator;

class Solution {
    public static void main(String[] args) {
        int[][] jobs = { { 0, 3 }, { 1, 9 }, { 2, 6 } };
        System.out.println(Solution(jobs));

    }

    public static int solution(int[][] jobs) {
        int answer = 0;
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < jobs.length; i++) {
            list.add(i);
        }

        Arrays.sort(jobs, Comparator.comparingInt(o1 -> o1[0]));

        // 최초값
        list.remove(0);
        int time = jobs[0][0] + jobs[0][1];
        answer = jobs[0][1] - jobs[0][0];

        while (list.size() > 0) {
            // min: 최소소요시간, idx: 해당 작업 리스트에서의 인덱스
            int min = Integer.MAX_VALUE, idx = -1;
            for (int i = 0; i < list.size(); i++) {
                if (jobs[list.get(i)][0] <= time) {
                    idx = i;
                    min = Math.min(min, jobs[list.get(i)][1]);
                } else {
                    break;
                }
            }

            // 끝났는데 바로 할 작업이 없는 경우는 가장 먼저 요청한거 해야함
            if (idx == -1) {
                time = jobs[list.get(0)][0] + jobs[list.get(0)][1];
                answer += time - jobs[list.get(0)][0];
                list.remove(0);
                continue;
            }

            time += jobs[list.get(idx)][1];
            answer += time - jobs[list.get(idx)][0];
            list.remove(idx);
        }

        return answer / jobs.length;
    }
}