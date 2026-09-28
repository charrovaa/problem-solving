import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int ans = 0;

        Set<Integer> left = new HashSet<>();
        Map<Integer, Integer> right = new HashMap<>();

        left.add(topping[0]);

        for (int i = 1; i < topping.length; i++) {
            right.merge(topping[i], 1, Integer::sum);
        }

        for (int i = 1; i < topping.length; i++) {
            int t = topping[i];
            if (left.size() == right.size()) ans++;
            left.add(t);
            if (right.merge(t, -1, Integer::sum) == 0) right.remove(t);
        }

        return ans;
    }
}