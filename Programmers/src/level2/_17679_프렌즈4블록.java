import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] map = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = board[i].charAt(j);
            }
        }

        List<Point> list = new ArrayList<>();
        list.add(new Point(0, 0));
        while (list.size() > 0) {
            list.clear();
            // 4개가 똑같은 부분 찾아서 list에 넣어주기
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (map[i][j] != '#' && map[i][j] == map[i + 1][j] && map[i][j] == map[i][j + 1]
                            && map[i][j] == map[i + 1][j + 1]) {
                        list.add(new Point(i, j));
                    }
                }
            }
            if (list.size() == 0)
                break;

            // 일단 그 부분들 *로 바꿔놓고
            for (Point point : list) {
                int x = point.x, y = point.y;
                map[x][y] = '*';
                map[x + 1][y] = '*';
                map[x][y + 1] = '*';
                map[x + 1][y + 1] = '*';
            }

            // 카운트 해주기
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == '*') {
                        answer++;
                    }
                }
            }

            // 부셔서 없애기 (아랫줄 왼쪽부터 오른쪽으로)
            for (int j = 0; j < n; j++) {
                // letters 리스트에 남은 알파벳 세로줄 담기
                List<Character> letters = new ArrayList<>();
                for (int i = m - 1; i >= 0; i--) {
                    if (map[i][j] != '*' && map[i][j] != '#') {
                        letters.add(map[i][j]);
                    }
                }
                // 남은 알파벳들 아래부터 순서대로 채워주기
                for (int i = 0; i < letters.size(); i++) {
                    map[m - 1 - i][j] = letters.get(i);
                }
                // 부서져서 없어진 칸들 #으로 채우기
                for (int i = 0; i < m - letters.size(); i++) {
                    map[i][j] = '#';
                }

            }

        }

        return answer;
    }

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}