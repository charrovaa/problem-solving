import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        final int DIVISOR = 65536;
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        int intersection = 0; // 교집합
        int union = 0; // 합집합

        count(map1, chunk(str1));
        count(map2, chunk(str2));

        Set<String> keySet = new HashSet<>();
        keySet.addAll(map1.keySet());
        keySet.addAll(map2.keySet());

        for (String key : keySet) {
            int val1 = map1.getOrDefault(key, 0);
            int val2 = map2.getOrDefault(key, 0);
            intersection += Math.min(val1, val2);
            union += Math.max(val1, val2);
        }

        if (union == 0) return 1 * DIVISOR;
        else return intersection * DIVISOR / union;
    }

    private String[] chunk(String str) {
        String[] result = new String[str.length() - 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = str.substring(i, i + 2);
        }
        return result;
    }

    private String normalize(String input) {
        char[] chars = input.toCharArray();
        String result = "";
        for (char c : chars) {
            if ((c >= 'a' && c <= 'z')) {
                result += c;
            } else if ((c >= 'A' && c <= 'Z')) {
                result += Character.toLowerCase(c);
            } else {
                return null;
            }
        }
        return result;
    }

    private void count(Map<String, Integer> map, String[] strs) {
        for (String str : strs) {
            String key = normalize(str);
            if (key != null) map.put(key, map.getOrDefault(key, 0) + 1);
        }
    }
}