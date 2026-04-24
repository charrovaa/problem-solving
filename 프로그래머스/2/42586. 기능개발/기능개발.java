import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] endDays = new int[101];
        int day = 1;
        for (int i = 0; i < progresses.length; i++) {
            while (progresses[i] + speeds[i] * day < 100) {
                day++;
            }
            endDays[day]++;
        }
        return Arrays.stream(endDays).filter(i -> i != 0).toArray();
    }
}