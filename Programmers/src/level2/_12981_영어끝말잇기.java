import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int num = 0;
        boolean flag = false;
        List<String> list = new ArrayList<>();

        char pre = words[0].charAt(0);
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            // 앞 단어의 마지막 글자와 다를 경우
            if (pre != word.charAt(0)) {
                num = i;
                flag = true;
                break;
            }
            // 이미 나온 단어일 경우
            if (list.contains(word)) {
                num = i;
                flag = true;
                break;
            }
            list.add(word);
            pre = word.charAt(word.length() - 1);
        }

        if (!flag) {
            answer[0] = 0;
            answer[1] = 0;
            return answer;
        }
        answer[0] = (num % n) + 1;
        answer[1] = (int) Math.ceil((double) (num + 1) / n);

        return answer;
    }
}