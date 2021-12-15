class Solution {

    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        int max = 0;
        for (int i = 0; i < number.length() - k; i++) {
            max = 0;
            for (int j = index; j <= k + i; j++) {
                if (max < number.charAt(j) - '0') {
                    max = number.charAt(j) - '0';
                    index = j + 1;
                }
            }
            sb.append(max);
        }
        return sb.toString();
    }

    private void combi(boolean[] v, String sel, int idx, int k) {
        // if (sel.length() == k) {
        // max = Math.max(max, Integer.parseInt(sel));
        // return;
        // }

        // if (idx == v.length) {
        // return;
        // }

        // 재귀
        // if (!v[idx]) {
        // v[idx] = true;
        // combi(v, sel + numArr[idx], idx + 1, k);
        // v[idx] = false;
        // combi(v, sel, idx+1, k);
        // }

        // 백트래킹
        // for (int i = idx; i < v.length; i++) {
        // v[i] = true;
        // combi(v, sel + numArr[idx], i + 1, k);
        // v[i] = false;
        // combi(v, sel, i + 1, k);
        // }

        // return;
    }
}