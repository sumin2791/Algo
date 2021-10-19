class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] board = new int[rows][columns];
        int tmp = 1, idx = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = tmp;
                tmp++;
            }
        }
        for (int[] numbers : queries) {
            int min = Integer.MAX_VALUE;
            int x1 = numbers[0] - 1, y1 = numbers[1] - 1, x2 = numbers[2] - 1, y2 = numbers[3] - 1;

            // 상
            int now = board[x1][y1], next = 0;
            for (int i = y1; i < y2; i++) {
                next = board[x1][i + 1];
                min = Math.min(min, next);
                board[x1][i + 1] = now;
                now = next;
            }

            // 우
            for (int i = x1; i < x2; i++) {
                next = board[i + 1][y2];
                min = Math.min(min, next);
                board[i + 1][y2] = now;
                now = next;
            }

            // 하
            for (int i = y2; i > y1; i--) {
                next = board[x2][i - 1];
                min = Math.min(min, next);
                board[x2][i - 1] = now;
                now = next;
            }

            // 좌
            for (int i = x2; i > x1; i--) {
                next = board[i - 1][y1];
                min = Math.min(min, next);
                board[i - 1][y1] = now;
                now = next;
            }

            answer[idx] = min;
            idx++;
        }
        return answer;
    }
}