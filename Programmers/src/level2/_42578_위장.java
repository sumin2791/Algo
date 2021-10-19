import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashSet<String> set = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            if (!map.containsKey(clothes[i][1])) {
                map.put(clothes[i][1], 2);
            } else {
                int tmp = map.get(clothes[i][1]);
                map.put(clothes[i][1], tmp + 1);
            }
            set.add(clothes[i][1]);
        }

        for (String kind : set) {
            int cnt = map.get(kind);
            answer *= cnt;
        }

        return answer - 1;
    }
}

// 각 종류 중 하나 혹은 안 입어야함
// 종류별 가지수를 구하고 +1(안 입는 경우)
// 모두 곱한 뒤 아예 하나도 안입는 경우를 하나 빼주면 됨
// HashMap에 종류를 key로 하고 value를 cnt로 해줌
// 안 입는 경우도 카운트 해줘야하니까 맵에 집어 넣을때부터 +1 해줌