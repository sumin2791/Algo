public class Solution {
    public int[] solution(int n) {
        int cnt = 1, dir = 0, r = 0, c = 0;
        int map[][] = new int[n][n];
        // answer개수: 1+2+...+n
        int[] answer = new int[n * (n + 1) / 2];

        while (cnt <= n * (n + 1) / 2) {
            map[r][c] = cnt;
            cnt++;
            if (dir == 0) { // down
                if (r == n - 1 || map[r + 1][c] != 0) {
                    dir = 1;
                    c++;
                } else {
                    r++;
                }
            } else if (dir == 1) { // right
                if (c == n - 1 || map[r][c + 1] != 0) {
                    dir = 2;
                    r--;
                    c--;
                } else {
                    c++;
                }
            } else { // up
                if (map[r - 1][c - 1] != 0) {
                    dir = 0;
                    r++;
                } else {
                    r--;
                    c--;
                }
            }
        }

        cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != 0) {
                    answer[cnt] = map[i][j];
                    cnt++;
                }
            }
        }
        return answer;
    }
}
