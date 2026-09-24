import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {

        int ans = 0;

        Map<String, Integer> wantMap = new HashMap<>();
        Map<String, Integer> windowMap = new HashMap<>();

        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], wantMap.getOrDefault(want[i], 0) + number[i]);
        }

        for (int i = 0; i < 10; i++) {
            windowMap.put(discount[i], windowMap.getOrDefault(discount[i], 0) + 1);
        }

        for (int i = 0; i <= discount.length - 10; i++) {
            boolean flag = true;
            if (i > 0) {
                windowMap.put(discount[i - 1], windowMap.get(discount[i - 1]) - 1);
                windowMap.put(discount[i + 9], windowMap.getOrDefault(discount[i + 9], 0) + 1);
            }
            for (String wantKey : wantMap.keySet()) {
                if (!windowMap.containsKey(wantKey)) flag = false;
                if (windowMap.getOrDefault(wantKey, 0) < wantMap.get(wantKey)) flag = false;
                if (!flag) break;
            }
            if (flag) ans++;
        }

        return ans;
    }
}