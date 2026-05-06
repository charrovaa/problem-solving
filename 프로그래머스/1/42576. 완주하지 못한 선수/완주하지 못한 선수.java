import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<String, Integer>();

        for (String string : participant) {
            if (map.containsKey(string)) {
                int value = map.get(string);
                map.replace(string, ++value);
            } else {
                map.put(string, 1);
            }
        }

        for (String string : completion) {
            int value = map.get(string);
            if (value == 1) {
                map.remove(string);
            } else {
                map.replace(string, --value);
            }
        }

        return map.keySet().iterator().next();
    }
}