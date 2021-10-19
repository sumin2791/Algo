package level1;

import java.util.ArrayList;

public class 모의고사 {
    public int[] solution(int[] answers) {
        int one = getOne(answers);
        int two = getTwo(answers);
        int three = getThree(answers);

        int max = one;
        max = Math.max(max, two);
        max = Math.max(max, three);

        ArrayList<Integer> list = new ArrayList<Integer>();
        if (max == one) {
            list.add(1);
        }
        if (max == two) {
            list.add(2);
        }
        if (max == three) {
            list.add(3);
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    private int getOne(int[] answers) {
        int cnt = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == (i % 5) + 1) {
                cnt++;
            }
        }
        return cnt;
    }

    private int getTwo(int[] answers) {
        int cnt = 0;
        for (int i = 0; i < answers.length; i++) {
            if (i % 2 == 0) {
                if (answers[i] == 2)
                    cnt++;
            } else {
                switch (i % 8) {
                    case 1:
                        if (answers[i] == 1)
                            cnt++;
                        break;
                    case 3:
                        if (answers[i] == 3)
                            cnt++;
                        break;
                    case 5:
                        if (answers[i] == 4)
                            cnt++;
                        break;
                    case 7:
                        if (answers[i] == 5)
                            cnt++;
                        break;
                }
            }
        }
        return cnt;
    }

    private int getThree(int[] answers) {
        int cnt = 0;
        for (int i = 0; i < answers.length; i++) {
            switch (i % 10) {
                case 0:
                case 1:
                    if (answers[i] == 3)
                        cnt++;
                    break;
                case 2:
                case 3:
                    if (answers[i] == 1)
                        cnt++;
                    break;
                case 4:
                case 5:
                    if (answers[i] == 2)
                        cnt++;
                    break;
                case 6:
                case 7:
                    if (answers[i] == 4)
                        cnt++;
                    break;
                case 8:
                case 9:
                    if (answers[i] == 5)
                        cnt++;
                    break;
            }
        }
        return cnt;
    }
}