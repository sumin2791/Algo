import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        if (cacheSize == 0) {
            return cities.length * 5;
        }

        List<String> cache = new ArrayList<String>();
        for (String city : cities) {
            city = city.toLowerCase();
            if (cache.contains(city)) {
                answer++;
                cache.remove(city);
                cache.add(city);
            } else if (cache.size() < cacheSize) {
                answer += 5;
                cache.add(city);
            } else {
                answer += 5;
                String rm = cache.get(0);
                cache.remove(rm);
                cache.add(city);
            }
        }
        return answer;
    }
}