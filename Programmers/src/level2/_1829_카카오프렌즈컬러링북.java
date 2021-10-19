class Solution {
    int[] dx = { -1, 1, 0, 0 };
    int[] dy = { 0, 0, -1, 1 };
    int numberOfArea = 0, maxSizeOfOneArea = 0;
    int cnt = 0;

    public int[] solution(int m, int n, int[][] picture) {
        int[] answer = new int[2];
        boolean[][] v = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] != 0 && !v[i][j]) {
                    numberOfArea++;
                    dfs(i, j, picture, v);
                }
                maxSizeOfOneArea = Math.max(maxSizeOfOneArea, cnt);
                cnt = 0;
            }
        }

        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

        return answer;
    }

    // DFS 메소드
    public void dfs(int x, int y, int[][] picture, boolean[][] v) {
        if (v[x][y])
            return;

        v[x][y] = true;
        cnt++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= picture.length || ny < 0 || ny >= picture[0].length)
                continue;

            if (picture[x][y] == picture[nx][ny] && !v[nx][ny]) {
                dfs(nx, ny, picture, v);
            }
        }
    }
}