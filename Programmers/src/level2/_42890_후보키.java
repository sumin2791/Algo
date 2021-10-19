import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    String[][] rel;
    int answer = 0;
    List<HashSet<Integer>> key_list = new ArrayList<>();

    public int solution(String[][] relation) {
        rel = relation;
        for (int i = 0; i < relation[0].length; i++) {
            combi(i + 1, 0, new HashSet<Integer>());
        }
        return answer;
    }

    private void combi(int cnt, int idx, HashSet<Integer> set) {
        if (set.size() == cnt) {

            // 유일성 체크
            if (!chkUnique(set)) {
                return;
            }
            // 최소성 체크
            for (HashSet<Integer> key_set : key_list) {
                if (set.containsAll(key_set)) {
                    return;
                }
            }
            key_list.add(set);
            answer++;
            return;
        }

        for (int i = idx; i < rel[0].length; i++) {
            HashSet<Integer> newSet = new HashSet<Integer>(set);
            newSet.add(i);
            combi(cnt, idx + 1, newSet);
        }

    }

    private boolean chkUnique(HashSet<Integer> set) {
        HashSet<String> key_set = new HashSet<>();
        for (int i = 0; i < rel.length; i++) {
            String str = "";
            for (Integer n : set) {
                str = str.concat(rel[i][n]);
            }
            key_set.add(str);
        }
        if (key_set.size() == rel.length)
            return true;
        return false;
    }
}