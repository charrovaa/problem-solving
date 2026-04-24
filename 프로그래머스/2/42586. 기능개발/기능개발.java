import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> progressesList = new ArrayList<>();
        for (int i : progresses) {
            progressesList.add(i);
        }

        List<Integer> speedsList = new ArrayList<>();
        for (int i : speeds) {
            speedsList.add(i);
        }

        List<Integer> counts = new ArrayList<>();

        while (!progressesList.isEmpty()) {
            int count = 0;
            for (int i = 0; i < progressesList.size(); i++) {
                progressesList.set(i, progressesList.get(i) + speedsList.get(i));
            }
            int i = 0;
            if (progressesList.get(0).intValue() >= 100) {
                for (Integer integer : progressesList) {
                    if (integer.intValue() < 100) {
                        break;
                    }
                    i++;
                }
                for (int j = i - 1; j >= 0; j--) {
                    progressesList.remove(j);
                    speedsList.remove(j);
                    count++;
                }
                counts.add(count);
            }
            
        }
        return counts.stream().mapToInt(i -> i).toArray();
    }
}