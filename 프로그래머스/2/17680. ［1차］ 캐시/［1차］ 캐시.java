import java.util.*;

class Solution {
    private static final int HIT = 1;
    private static final int MISS = 5;

    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return cities.length * MISS;

        LinkedHashMap<String, Boolean> cache = new LinkedHashMap<>(cacheSize, 0.75f, true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, Boolean> eldest) {
                return size() > cacheSize;
            }
        };

        int answer = 0;

        for (String city : cities) {
            city = city.toLowerCase();
            if (cache.containsKey(city)) answer += HIT;
            else answer += MISS;
            cache.put(city, true);
        }

        return answer;
    }
}