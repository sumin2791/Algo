import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < priorities.length; i++) {
            int[] arr = new int[2];
            arr[0] = priorities[i];
            arr[1] = i;
            list.add(arr);
        }

        while (list.size() > 0) {
            boolean flag = true;
            int[] arr = list.remove(0);
            for (int i = 0; i < list.size(); i++) {
                if (arr[0] < list.get(i)[0]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                answer++;
                if (arr[1] == location) {
                    return answer;
                }
            } else {
                list.add(arr);
            }

        }

        return answer;
    }
}
