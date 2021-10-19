import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;

        List<Integer> list = new ArrayList<>();
        for (int i : people) {
            list.add(i);
        }

        Collections.sort(list);

        int now = 0;
        for (int j = people.length - 1; now <= j; j--) {
            if (list.get(now) + list.get(j) <= limit) {
                now++;
            }
            answer++;
        }

        // while (list.size() > 0) {
        // if (list.size() == 1) {
        // answer++;
        // break;
        // }
        // if (list.get(list.size() - 1) <= limit / 2) {
        // answer += Math.ceil(list.size() / 2);
        // break;
        // }
        // if (list.get(0) + list.get(list.size() - 1) > limit) {
        // answer++;
        // list.remove(list.size() - 1);
        // } else {
        // answer++;
        // list.remove(list.size() - 1);
        // list.remove(0);
        // }
        // }

        return answer;
    }
}

// import java.util.ArrayList;
// import java.util.List;

// class Solution {
// boolean[] chk;
// int answer = Integer.MAX_VALUE;
// List<Integer> list = new ArrayList<>();

// public int solution(int[] people, int limit) {
// for (int i = 0; i < people.length; i++) {
// list.add(i);
// }
// chk = new boolean[people.length];

// boat(people, limit, 0, 0, 0);

// return answer;
// }

// private void boat(int[] people, int limit, int cnt, int ans, int sum) {
// // cnt: 뽑은 개수, ans: 보트 횟수, sum: 지금까지 뽑은 무게
// if (list.size() == 0) {
// answer = Math.min(answer, ans);
// return;
// }
// if (cnt >= 2) {
// boat(people, limit, 0, ans + 1, 0);
// } else if (cnt == 1) {
// // 하나만 보트에 태우는 경우
// boat(people, limit, 0, ans + 1, 0);
// // ㅣ금은 안뽑는 경우
// int tmp = list.remove(0);
// list.add(tmp);
// boat(people, limit, cnt, ans, sum);
// // 지금 하나 더 뽑는 경우
// tmp = list.remove(list.size() - 1);
// int weight = people[tmp];
// if (sum + tmp <= limit) {
// boat(people, limit, cnt + 1, ans, sum + weight);
// list.add(0, tmp);
// }
// } else {
// int tmp = list.remove(0);
// list.add(tmp);
// boat(people, limit, cnt, ans, sum);
// // 지금 하나 뽑는 경우
// tmp = list.remove(list.size() - 1);
// int weight = people[tmp];
// if (sum + tmp <= limit) {
// boat(people, limit, cnt + 1, ans, sum + weight);
// list.add(0, tmp);
// }
// }

// }
// }