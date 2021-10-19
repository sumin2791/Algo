import java.util.ArrayList;
import java.util.List;

class Solution {
    long answer = 0;
    char[] operation = { '+', '-', '*' };
    boolean[] chk = new boolean[3];
    List<Character> operList = new ArrayList<>();
    List<Long> numList = new ArrayList<>();

    public long solution(String expression) {
        char[] oper = new char[3];

        // 문자에서 연산자 리스트에 담고 숫자 분리해서 담기
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*') {
                operList.add(expression.charAt(i));
            }
        }
        expression = expression.replace("+", "#");
        expression = expression.replace("-", "#");
        expression = expression.replace("*", "#");

        String[] numbers = expression.split("#");

        for (String num : numbers) {
            numList.add(Long.parseLong(num));
        }

        permutation(oper, 0);

        return answer;
    }

    // 순열 뽑기(우선 순위)
    private void permutation(char[] oper, int cnt) {
        if (cnt == 3) {
            oper(oper);
        }

        for (int i = 0; i < 3; i++) {
            if (!chk[i]) {
                chk[i] = true;
                oper[cnt] = operation[i];
                permutation(oper, cnt + 1);
                chk[i] = false;
            }
        }
    }

    // 수식값 계산
    private void oper(char[] oper) {
        ArrayList<Long> nums = new ArrayList<>(numList);
        ArrayList<Character> opers = new ArrayList<>(operList);
        for (char c : oper) {
            for (int i = 0; i < opers.size(); i++) {
                if (c == opers.get(i)) {
                    long num = calc(nums.remove(i), nums.remove(i), c);
                    nums.add(i, num);
                    opers.remove(i);
                    i--;
                }
            }
        }

        answer = Math.max(answer, Math.abs(nums.remove(0)));
    }

    // 연산
    private long calc(Long one, Long two, char c) {
        switch (c) {
            case '+':
                return one + two;
            case '-':
                return one - two;
            case '*':
                return one * two;
        }

        return 0;
    }
}