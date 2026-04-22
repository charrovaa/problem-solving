import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int[] citations) {
        List<Integer> list = new ArrayList<>();

        for (int i : citations) {
            list.add(i);
        }

        list.sort((a, b) -> { return b - a; });

        int max = 0;

        for (int i = 0; i < list.size(); i++) {
            if (i + 1 <= list.get(i)) max = i + 1;
        }

        return max;
    }
}