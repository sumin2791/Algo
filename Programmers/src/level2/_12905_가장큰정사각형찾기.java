class Solution {
    int[][] b;
    int answer = 0;

    public int solution(int[][] board) {
        if (board.length == 1 || board[0].length == 1) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == 1) {
                        return 1;
                    }
                }
            }

            return 0;
        }

        b = board;

        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    int l = b[i][j - 1];
                    int u = b[i - 1][j];
                    int lu = b[i - 1][j - 1];

                    b[i][j] = Math.min(l, Math.min(u, lu)) + 1;
                    answer = Math.max(answer, b[i][j] * b[i][j]);
                }
            }
        }
        return answer;
    }

}