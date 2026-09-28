import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return cities.length * 5;
        int answer = 0;
        List<String> cache = new LinkedList<>();
        for (int i = 0; i < cities.length; i++) cities[i] = cities[i].toLowerCase();
        for (int i = 0; i < cities.length; i++) {
            if (cache.contains(cities[i])) {
                cache.remove(cities[i]);
                cache.addFirst(cities[i]);
                answer += 1;
            } else {
                if (cache.size() == cacheSize) {
                    cache.removeLast();
                }
                cache.addFirst(cities[i]);
                answer += 5;
            }
        }
        return answer;
    }
}