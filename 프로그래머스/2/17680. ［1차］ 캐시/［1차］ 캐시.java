import java.util.LinkedList;

class Solution {
    private static final int HIT = 1;
    private static final int MISS = 5;

    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return cities.length * MISS;

        int answer = 0;
        LinkedList<String> cache = new LinkedList<>();

        for (String city : cities) {
            city = city.toLowerCase();

            if (cache.remove(city)) {
                answer += HIT;
            } else {
                if (cache.size() == cacheSize) cache.removeLast();
                answer += MISS;
            }
            
            cache.addFirst(city);
        }

        return answer;
    }
}