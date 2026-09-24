import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {

        int match = 0;
        int ans = 0;

        Map<String, Integer> wantMap = new HashMap<>();
        Map<String, Integer> windowMap = new HashMap<>();

        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], wantMap.getOrDefault(want[i], 0) + number[i]);
        }

        for (int i = 0; i < 10; i++) {
            windowMap.put(discount[i], windowMap.getOrDefault(discount[i], 0) + 1);
            if (windowMap.get(discount[i]) == wantMap.getOrDefault(discount[i], 0)) match++;
        }

        for (int i = 0; i <= discount.length - 10; i++) {
            if (i > 0) {
                boolean wasMatch = windowMap.getOrDefault(discount[i - 1], 0) >= wantMap.getOrDefault(discount[i - 1], 0);
                windowMap.put(discount[i - 1], windowMap.get(discount[i - 1]) - 1);
                boolean isMatch = windowMap.getOrDefault(discount[i - 1], 0) >= wantMap.getOrDefault(discount[i - 1], 0);
                if (wasMatch && !isMatch) match--;

                wasMatch = windowMap.getOrDefault(discount[i + 9], 0) >= wantMap.getOrDefault(discount[i + 9], 0);
                windowMap.put(discount[i + 9], windowMap.getOrDefault(discount[i + 9], 0) + 1);
                isMatch = windowMap.getOrDefault(discount[i + 9], 0) >= wantMap.getOrDefault(discount[i + 9], 0);
                if (!wasMatch && isMatch) match++;
            }

            if (match == wantMap.size()) ans++;
        }

        return ans;
    }
}