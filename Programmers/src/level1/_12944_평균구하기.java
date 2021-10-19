package level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class _12944_평균구하기 {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };
        solution(arr);
    }

    static public int[] solution(int[] arr) {
        double answer = 0;

        for (int i : arr) {
            answer += i;
        }

        answer /= arr.length;

        return answer;
    }
}