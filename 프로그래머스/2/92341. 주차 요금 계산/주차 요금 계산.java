import java.util.TreeMap;

class Solution {
    private static final int END_OF_DAY = 23 * 60 + 59;
    public int[] solution(int[] fees, String[] records) {
        TreeMap<String, Integer> map = new TreeMap<>();
        for (String record : records) {
            String[] data = record.split(" ");
            int sign = data[2].equals("OUT") ? 1 : -1;
            map.put(data[1], map.getOrDefault(data[1], 0) + sign * toMinutes(data[0]));
        }
        int[] ans = new int[map.size()];
        int idx = 0;
        for (int min : map.values()) {
            if (min <= 0) min += END_OF_DAY;
            ans[idx++] = (min <= fees[0] ? 0 : (min - fees[0] + fees[2] - 1) / fees[2] * fees[3]) + fees[1];
        }
        return ans;
    }
    private int toMinutes(String time) {
        return Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3));
    }
}