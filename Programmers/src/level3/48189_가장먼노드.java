import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int n, int[][] edge) {
        boolean[][] node = new boolean[n + 1][n + 1];
        boolean[] check = new boolean[n + 1];
        for (int i = 0; i < edge.length; i++) {
            node[edge[i][0]][edge[i][1]] = true;
            node[edge[i][1]][edge[i][0]] = true;
        }

        Queue<Integer> queue = new LinkedList<>();
        int answer = 0;
        queue.add(1);

        while (!queue.isEmpty()) {
            answer = queue.size();

            for (int i = 0; i < answer; i++) {
                int pre = queue.poll();

                for (int next = 2; next <= n; next++) {
                    if (check[next] || !node[pre][next])
                        continue;
                    check[next] = true;
                    queue.add(next);
                }
            }
        }

        return answer;
    }
}