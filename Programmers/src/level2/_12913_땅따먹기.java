class Solution {
    int solution(int[][] land) {
        int answer = 0;

        for (int i = 1; i < land.length; i++) {
            land[i][0] += Math.max(land[i - 1][1], Math.max(land[i - 1][2], land[i - 1][3]));
            land[i][1] += Math.max(land[i - 1][0], Math.max(land[i - 1][2], land[i - 1][3]));
            land[i][2] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][3]));
            land[i][3] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][2]));
        }

        for (int i = 0; i < 4; i++) {
            answer = Math.max(answer, land[land.length - 1][i]);
        }

        return answer;
    }
}

// class Solution {
// int solution(int[][] land) {
// int answer = 0;
// int sum[] = new int[4];

// for (int i = 0; i < 4; i++) {
// sum[i] = land[0][i];
// }
// for (int i = 1; i < land.length; i++) {
// sum[0] += Math.max(land[i][1], Math.max(land[i][2], land[i][3]));
// sum[1] += Math.max(land[i][0], Math.max(land[i][2], land[i][3]));
// sum[2] += Math.max(land[i][0], Math.max(land[i][1], land[i][3]));
// sum[3] += Math.max(land[i][0], Math.max(land[i][1], land[i][2]));
// }

// for (int i = 0; i < 4; i++) {
// answer = Math.max(answer, sum[i]);
// }

// return answer;
// }
// }

// class Solution {
// int answer = 0;

// int solution(int[][] land) {
// game(land, 0, 0, -1);

// return answer;
// }

// private void game(int[][] land, int idx, int sum, int pre) {
// if (idx == land.length) {
// answer = Math.max(answer, sum);
// return;
// }

// for (int i = 0; i < 4; i++) {
// if (pre != i) {
// game(land, idx + 1, sum + land[idx][i], i);
// }
// }
// }
// }
