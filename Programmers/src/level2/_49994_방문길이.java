class Solution {
    public int solution(String dirs) {
        int answer = 0;
        boolean[][][][] v = new boolean[11][11][11][11];

        int x = 5, y = 5;
        for (int i = 0; i < dirs.length(); i++) {
            switch (dirs.charAt(i)) {
                case 'U':
                    if (y != 0) {
                        y--;
                        if (!v[x][y][x][y + 1]) {
                            v[x][y][x][y + 1] = true;
                            answer++;
                        }
                    }
                    break;
                case 'D':
                    if (y != 10) {
                        y++;
                        if (!v[x][y - 1][x][y]) {
                            v[x][y - 1][x][y] = true;
                            answer++;
                        }
                    }
                    break;
                case 'R':
                    if (x != 10) {
                        x++;
                        if (!v[x - 1][y][x][y]) {
                            v[x - 1][y][x][y] = true;
                            answer++;
                        }
                    }
                    break;
                case 'L':
                    if (x != 0) {
                        x--;
                        if (!v[x][y][x + 1][y]) {
                            v[x][y][x + 1][y] = true;
                            answer++;
                        }
                    }
                    break;

            }

        }
        return answer;
    }
}