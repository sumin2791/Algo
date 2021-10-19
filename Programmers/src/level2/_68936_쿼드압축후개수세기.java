class Solution {
    int[] answer = new int[2];

    public int[] solution(int[][] arr) {
        int num = arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] != num) {
                    num = -1;
                    break;
                }
            }
        }
        if (num != -1) {
            answer[num]++;
            return answer;
        }

        int cnt = arr.length;
        zip(arr, 0, 0, cnt / 2);
        zip(arr, 0, cnt / 2, cnt / 2);
        zip(arr, cnt / 2, 0, cnt / 2);
        zip(arr, cnt / 2, cnt / 2, cnt / 2);

        return answer;
    }

    private void zip(int[][] arr, int x, int y, int cnt) {
        if (cnt == 1) {
            answer[arr[x][y]]++;
            return;
        }

        int num = arr[x][y];
        for (int i = x; i < x + cnt; i++) {
            for (int j = y; j < y + cnt; j++) {
                if (arr[i][j] != num) {
                    // 압축안되는 경우
                    num = -1;
                    break;
                }
            }
        }

        if (num != -1) {
            // 압축 되는 경우
            answer[num]++;
            return;
        }

        cnt /= 2;
        zip(arr, x, y, cnt);
        zip(arr, x, y + cnt, cnt);
        zip(arr, x + cnt, y, cnt);
        zip(arr, x + cnt, y + cnt, cnt);

    }
}