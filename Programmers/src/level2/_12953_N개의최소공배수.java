class Solution {
    public int solution(int[] arr) {
        int answer = 0, idx = 1;
        while (idx > 0) {
            boolean flag = true;
            for (int i = 0; i < arr.length; i++) {
                if (idx % arr[i] != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return idx;
            }
            idx++;
        }
        return answer;
    }
}