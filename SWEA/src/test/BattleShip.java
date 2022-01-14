import java.util.Scanner;

class Solution {
    final static int board[][] = new int[10][10];

    private final static int MISS = 0;
    private final static int CARRIER = 1;
    private final static int BATTLESHIP = 2;
    private final static int CRUISER = 3;
    private final static int SUBMARINE = 4;
    private final static int DESTROYER = 5;

    private static int hit;
    private final static int len[] = { 5, 4, 3, 3, 2 };

    private final static int MAX_CALLCOUNT = 10000;

    private static int callcount;
    private static int limit;

    private final static UserSolution usersolution = new UserSolution();

    public static int fire(int r, int c) {
        if (r < 0 || r > 9 || c < 0 || c > 9 || callcount >= MAX_CALLCOUNT) {
            callcount = MAX_CALLCOUNT;
            return 0;
        }

        ++callcount;

        int ret = board[r][c];

        if (board[r][c] > 0)
            --hit;
        board[r][c] = 0;

        return ret;
    }

    private static int seed;

    private static int pseudo_rand() {
        seed = seed * 214013 + 2531011;
        return (seed >> 16) & 0x7fff;
    }

    private static boolean check(int r, int c, int d, int l) {
        if (d == 1) {
            for (int m = 0; m < l; ++m)
                if (board[r][c + m] > 0)
                    return false;
            return true;
        } else {
            for (int m = 0; m < l; ++m)
                if (board[r + m][c] > 0)
                    return false;
            return true;
        }
    }

    private static void doarrangement() {
        for (int r = 0; r < 10; ++r)
            for (int c = 0; c < 10; ++c)
                board[r][c] = 0;

        for (int k = 0; k < 5; ++k) {
            while (true) {
                int r, c, d;

                d = pseudo_rand() % 2;
                if (d == 1) {
                    r = pseudo_rand() % 10;
                    c = pseudo_rand() % (10 - len[k] + 1);
                    if (check(r, c, d, len[k])) {
                        for (int l = 0; l < len[k]; ++l)
                            board[r][c + l] = k + 1;
                        break;
                    }
                } else {
                    r = pseudo_rand() % (10 - len[k] + 1);
                    c = pseudo_rand() % 10;
                    if (check(r, c, d, len[k])) {
                        for (int l = 0; l < len[k]; ++l)
                            board[r + l][c] = k + 1;
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int TC, totalscore, totalcallcount;

        // System.setIn(new java.io.FileInputStream("res/sample_input.txt"));
        Scanner sc = new Scanner(System.in);
        TC = sc.nextInt();

        totalscore = totalcallcount = 0;
        for (int testcase = 1; testcase <= TC; ++testcase) {
            int score = 100, callcount4tc = 0;

            seed = sc.nextInt();
            limit = sc.nextInt();

            usersolution.init(limit);

            for (int game = 0; game < 10; ++game) {
                doarrangement();

                hit = 0;
                for (int k = 0; k < 5; ++k)
                    hit += len[k];

                callcount = 0;
                usersolution.play();

                if (hit != 0)
                    callcount = MAX_CALLCOUNT;

                if (callcount > limit)
                    score = 0;

                callcount4tc += callcount;
            }

            System.out.println("#" + testcase + " " + score + " " + callcount4tc);

            totalscore += score;
            totalcallcount += callcount4tc;
        }

        System.out.println("total score = " + totalscore / TC + ", total callcount = " + totalcallcount);
        sc.close();
    }
}

class UserSolution {
    // Main API :
    // Solution.fire(int r, int c)

    int board[][] = new int[10][10];

    private final static int MISS = 0;
    private final static int CARRIER = 1;
    private final static int BATTLESHIP = 2;
    private final static int CRUISER = 3;
    private final static int SUBMARINE = 4;
    private final static int DESTROYER = 5;

    public void init(int limit) {

    }

    public void play() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board[i][j] = -1;
                if (Stock.fire(i, j) != 0) {
                    ship(i, j);
                }
            }
        }
    }

    private void ship(int i, int j) {
        if (i < 10 && j + 1 < 10 && board[i][j + 1] != -1 && Stock.fire(i, j + 1) != 0) {
            board[i][j + 1] = -1;
            ship(i, j + 1);
        }
        if (i + 1 < 10 && j < 10 && board[i + 1][j] != -1 && Stock.fire(i + 1, j) != 0) {
            board[i + 1][j] = -1;
            ship(i + 1, j);
        }
        if (i + 1 < 10 && j + 1 < 10 && board[i + 1][j + 1] != -1 && Stock.fire(i + 1, j + 1) != 0) {
            board[i + 1][j + 1] = -1;
            ship(i + 1, j + 1);
        }
    }
}
