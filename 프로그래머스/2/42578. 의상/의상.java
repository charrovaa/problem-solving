import java.util.*;

class Solution {
    public int solution(String[][] clothes) {

        Map<String, Integer> map = new HashMap<String, Integer>();
        int answer = 1;

        for (String[] item : clothes) {
            String key = item[1];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        Iterator<Integer> iterator = map.values().iterator();

        while (iterator.hasNext()) {
            answer *= iterator.next() + 1;
        }
        
        return answer - 1;
    }
}