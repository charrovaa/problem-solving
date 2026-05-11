import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean solution(String[] phone_book) {

        Map<String, Integer> map = new HashMap<String, Integer>();

        for (String string : phone_book) {
            map.put(string, 1);
        }

        for (String string : phone_book) {
            for (int i = 1; i < string.length(); i++) {
                if (map.containsKey(string.substring(0, i))) return false;
            }
        }

        return true;
    }
}