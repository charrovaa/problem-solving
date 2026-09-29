import java.util.*;

class Solution {
    private static final int HIT = 1;
    private static final int MISS = 5;

    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return cities.length * MISS;

        // 해시맵 + 순서 보장 (true : get 조회, put 삽입/수정 시점에 해당 항목을 맨 뒤로 이동)
        LinkedHashMap<String, Boolean> cache = new LinkedHashMap<>(cacheSize, 0.75f, true){
            @Override // 가장 앞에 (오래된) 위치한 원소 삭제 기준
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