import java.util.LinkedList;
import java.util.Queue;

class Solution {
    // 0: 벽, 1: 없음
    int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };
    int n, m;
    int answer = Integer.MAX_VALUE;
    boolean[][] v;

    class Node {
        int x;
        int y;
        int cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;

        v = new boolean[n][m];

        BFS(maps);
        if (answer == Integer.MAX_VALUE)
            return -1;
        return answer;
    }

    private void BFS(int[][] maps) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 0));
        v[0][0] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node.x == n - 1 && node.y == m - 1) {
                answer = Math.min(answer, node.cnt + 1);
                return;
            }

            int[] dx = { -1, 1, 0, 0 };
            int[] dy = { 0, 0, -1, 1 };
            for (int i = 0; i < 4; i++) {
                int xx = node.x + dx[i];
                int yy = node.y + dy[i];
                if (xx >= 0 && xx < n && yy >= 0 && yy < m) {
                    if (maps[xx][yy] != 0 && !v[xx][yy]) {
                        v[xx][yy] = true;
                        q.offer(new Node(xx, yy, node.cnt + 1));
                    }
                }
            }
        }

    }
}