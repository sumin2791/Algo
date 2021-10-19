class Solution {
    int answer = Integer.MAX_VALUE;

    public int solution(String begin, String target, String[] words) {

        word(begin, target, words, new boolean[words.length], 0);

        if (answer == Integer.MAX_VALUE)
            return 0;

        return answer;
    }

    private void word(String begin, String target, String[] words, boolean[] v, int idx) {
        if (begin.equals(target)) {
            answer = Math.min(answer, idx);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (!v[i]) {
                int cnt = 0;
                // 한글자만 다른 단어 찾기
                for (int j = 0; j < begin.length(); j++) {
                    if (begin.charAt(j) == words[i].charAt(j)) {
                        cnt++;
                    }
                }
                if (cnt == begin.length() - 1) {
                    v[i] = true;
                    word(words[i], target, words, v, idx + 1);
                    v[i] = false;
                }
            }
        }
    }
}