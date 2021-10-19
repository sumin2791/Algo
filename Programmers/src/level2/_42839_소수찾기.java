import java.util.HashSet;
import java.util.Set;

class Solution {
    int[] num = new int[10];
    Set<Integer> numSet = new HashSet<>();

    public int solution(String numbers) {
        int answer = 0;

        for (int i = 0; i < numbers.length(); i++) {
            int tmp = Character.getNumericValue(numbers.charAt(i));
            num[tmp]++;
        }

        for (int i = 1; i <= numbers.length(); i++) {
            dfs(numbers, "", i);
        }

        for (Integer i : numSet) {
            if (isPrime(i)) {
                answer++;
            }
        }
        return answer;
    }

    private boolean isPrime(Integer i) {
        if (i == 0 || i == 1)
            return false;

        for (int j = 2; j <= Math.sqrt(i); j++) {
            if (i % j == 0) {
                return false;
            }
        }

        return true;
    }

    private void dfs(String numbers, String ans, int i) {
        if (ans.length() == i) {
            numSet.add(Integer.parseInt(ans));
            return;
        } else {
            for (int j = 0; j < num.length; j++) {
                if (num[j] > 0) {
                    num[j]--;
                    dfs(numbers, ans + Integer.toString(j), i);
                    num[j]++;

                }
            }
        }
    }
}