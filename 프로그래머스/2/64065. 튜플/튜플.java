import java.util.*;
import java.util.regex.*;

class Solution {
    public int[] solution(String s) {
        Map<String, Integer> map = new HashMap<>();
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            String num = matcher.group();
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int size = map.size();
        int[] ans = new int[size];
        for (String key : map.keySet()) {
            ans[size - map.get(key)] = Integer.parseInt(key);
        }
        return ans;
    }
}