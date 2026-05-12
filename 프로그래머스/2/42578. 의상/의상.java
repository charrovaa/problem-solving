import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {

        Map<String, Integer> map = new HashMap<String, Integer>();
        int answer = 1;

        for (String[] strings : clothes) {
            String key = strings[1];
            if (map.containsKey(key)) {
                int val = map.get(key);
                map.replace(key, ++val);
            } else {
                map.put(key, 1);
            }
        }

        for (int i : map.values()) {
            answer *= i + 1;
        }
        return answer - 1;
    }
}