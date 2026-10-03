import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        final int DIVISOR = 65536;
        Map<String, int[]> map = new HashMap<>();

        double intersection = 0; // 교집합
        double union = 0; // 합집합

        count(map, chunk(str1), 1);
        count(map, chunk(str2), 2);

        for (int[] cnts : map.values()) {
            intersection += Math.min(cnts[0], cnts[1]);
            union += Math.max(cnts[0], cnts[1]);
        }

        if (union == 0) return 1 * DIVISOR;
        else return (int)((intersection / union) * DIVISOR);
    }

    private String[] chunk(String str) {
        String[] result = new String[str.length() - 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = str.substring(i, i + 2);
        }
        return result;
    }

    private String filter(String input) {
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

    private void count(Map<String, int[]> map, String[] strs, int num) {
        for (String str : strs) {
            String s = filter(str);
            if (s == null) continue;
            int[] cnts;
            if (map.containsKey(s)) {
                cnts = map.get(s);
            } else {
                cnts = new int[]{0, 0};
            }
            cnts[num - 1] += 1;
            map.put(s, cnts);
        }
    }
}