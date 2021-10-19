import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] numlist = s.split(" ");
        int[] num = new int[numlist.length];

        for (int i = 0; i < num.length; i++) {
            num[i] = Integer.parseInt(numlist[i]);
        }

        Arrays.sort(num);
        answer = Integer.toString(num[0]) + " " + Integer.toString(num[num.length - 1]);
        return answer;
    }
}