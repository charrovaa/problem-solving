import java.time.Duration;
import java.time.LocalTime;
import java.util.*;

class Solution {
    private Map<String, LocalTime> outMap = new HashMap<>();
    private TreeMap<String, Integer> timeMap = new TreeMap<>();

    public int[] solution(int[] fees, String[] records) {
        for (int i = records.length - 1; i >= 0; i--) {
            String[] data = records[i].split(" ");
            parse(data[0], data[1], data[2]);
        }

        int[] ans = new int[timeMap.size()];
        int idx = 0;

        for (int fee : timeMap.values()) {
            if (fee <= fees[0]) ans[idx++] = fees[1];
            else ans[idx++] = fees[1] + (int) Math.ceil((double) (fee - fees[0]) / fees[2]) * fees[3];
        }
        
        return ans;
    }

    // 나간 차 기록 -> 들어온 차와 묶어서 연산 -> 나간 적이 없는 들어온 차는 기본 값으로 연산
    private void parse(String time, String car, String inOut) {
        LocalTime t = LocalTime.parse(time);
        if (inOut.equals("OUT")) outMap.put(car, t);
        if (inOut.equals("IN")) {
            int min = (int) Duration.between(t, outMap.getOrDefault(car, LocalTime.of(23, 59))).toMinutes();
            timeMap.put(car, timeMap.getOrDefault(car, 0) + min);
        }
    }
}