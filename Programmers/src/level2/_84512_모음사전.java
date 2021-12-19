class Solution {
    public int solution(String word) {
        int answer = 0;

        String[] alpha = { "A", "E", "I", "O", "U" };

        int[] past_words = { 781, 156, 31, 6, 1 };

        String[] temp = word.split("");

        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < alpha.length; j++) {
                if (temp[i].equals(alpha[j])) {
                    answer += past_words[i] * j + 1;
                    break;
                }
            }
        }

        return answer;
    }
}
