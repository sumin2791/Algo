class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String skillTree : skill_trees) {
            int[] order = new int[skill.length()];
            boolean flag = true;

            // 해당 스킬 포함하고 있다면 어느 위치인지 order 배열에 담기
            for (int i = 0; i < skill.length(); i++) {
                if (skillTree.contains(Character.toString(skill.charAt(i)))) {
                    order[i] = skillTree.indexOf(Character.toString(skill.charAt(i))) + 1;
                }
            }

            // 뒷 기술들은 필수는 아니기 때문에 후에 비교할때 문제 없기 위해 뒷 0들은 최대값으로 변경
            for (int i = order.length - 1; i >= 0; i--) {
                if (order[i] == 0) {
                    order[i] = Integer.MAX_VALUE;
                } else {
                    break;
                }
            }

            // 뒷 기술들이 앞 기술보다 작으면 거짓 리턴
            int pre = 1;
            for (int i = 0; i < order.length; i++) {
                if (pre <= order[i]) {
                    pre = order[i];
                } else {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                answer++;
            }

        }

        return answer;
    }
}