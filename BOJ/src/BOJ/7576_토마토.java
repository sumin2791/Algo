import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int ans = 0;
    static int[] dr = { 0, 0, 1, -1 };
    static int[] dc = { 1, -1, 0, 0 };
    static int M, N, Ans;
    static int[][] box;

    static class Tomato {
        int r, c, day;

        Tomato(int r, int c, int day) {
            this.r = r;
            this.c = c;
            this.day = day;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {

        // System.setIn(new FileInputStream("토마토.txt"));
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        box = new int[N][M];
        boolean[][] v = new boolean[N][M];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                box[r][c] = sc.nextInt();
            }
        }
        // print(box);
        Queue<Tomato> Q = new LinkedList<Tomato>();
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (box[r][c] == 1) {
                    Q.add(new Tomato(r, c, 0));
                    v[r][c] = true;
                }
            }
        }
        while (!Q.isEmpty()) {
            Tomato p = Q.poll();
            Ans = Math.max(Ans, p.day);
            for (int k = 0; k < 4; k++) {
                int nr = p.r + dr[k];
                int nc = p.c + dc[k];
                if (nr >= 0 && nr < N && nc >= 0 && nc < M && !v[nr][nc]
                        && box[nr][nc] == 0) {
                    v[nr][nc] = true;
                    Q.add(new Tomato(nr, nc, p.day + 1));
                }
            }
        }
        if (check(v)) {
            Ans = -1;
        }

        System.out.println(Ans);
    }

    private static boolean check(boolean[][] v) {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (box[r][c] == 0 && v[r][c] == false) {
                    return true;
                }
            }
        }

        return false;
    }

    private static void print(int[][] box) {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                System.out.print(box[r][c] + " ");
            }
            System.out.println();
        }
    }
}
