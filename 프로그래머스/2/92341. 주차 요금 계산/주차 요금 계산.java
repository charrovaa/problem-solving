import java.util.*;

class Solution {
    private static final int END_OF_DAY = 23 * 60 + 59;

    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> outMap = new HashMap<>();
        TreeMap<String, Integer> total = new TreeMap<>();
        for (int i = records.length - 1; i >= 0; i--) { // 역순으로 순회
            String[] record = records[i].split(" "); // 시각, 차량번호, 내역
            if (record[2].equals("OUT")) outMap.put(record[1], toMinutes(record[0]));
            else {
                int in = toMinutes(record[0]);
                int out = outMap.getOrDefault(record[1], END_OF_DAY);
                total.put(record[1], total.getOrDefault(record[1], 0) + (out - in));
            }
        }
        int[] answer = new int[total.size()];
        int idx = 0;
        for (int min : total.values()) {
            answer[idx++] = calcFee(fees, min);
        }
        return answer;
    }

    private int calcFee(int[] fees, int min) {
        if (min <= fees[0]) return fees[1];
        return fees[1] + ((min - fees[0] + fees[2] - 1) / fees[2]) * fees[3];
    }

    private int toMinutes(String time) {
        return Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3));
    }
}