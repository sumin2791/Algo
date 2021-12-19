import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Solution {
    // "2016-09-15 00:00:00.000 2.3s", "2016-09-15 23:59:59.999 0.1s"
    Map<Double, Integer> map = new HashMap<>();

    public int solution(String[] lines) {
        for (String line : lines) {
            // 초 단위로 변환
            String time[] = line.split(" ")[1].split(":");
            double end = Double.parseDouble(time[0]) * 3600 + Double.parseDouble(time[1]) * 60
                    + Double.parseDouble(time[2]) + 3;

            // 시작 시간 구하기
            double T = Double.parseDouble(line.split(" ")[2].replace("s", ""));
            double start = end - T + 0.001;

            // !!!!!!!!!!!!!!
            System.out.println(line);
            getTraffic(start, end);
        }

        // 초별로 카운트해서 최댓값 찾기
        int answer = 0;
        Set<Double> set = map.keySet();
        for (Double sec : set) {
            int cnt = map.get(sec);
            System.out.println("sec: " + sec + " cnt: " + cnt);
            answer = Math.max(answer, cnt);
        }
        return answer;
    }

    private void getTraffic(double start, double end) {
        while (start <= end) {
            if (map.containsKey(start)) {
                int cnt = map.get(start);
                map.replace(start, cnt + 1);
            } else {
                map.put(start, 1);
            }
            start += 0.001;
        }
    }
}