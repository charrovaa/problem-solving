import java.util.*;

class Solution {
    public int solution(int N, int number) {
        List<Set<Integer>> dp = new ArrayList<>();
        dp.add(0, new HashSet<Integer>(Set.of(0)));

        for (int i = 1; i <= 8; i++) {
            Set<Integer> set = new HashSet<Integer>();
            String n = new String();
            for (int j = 1; j <= i; j++) {
                n += N;
            }
            set.add(Integer.parseInt(n));
            for (int j = 1; j < i; j++) {
                for (Integer e1 : dp.get(j)) {
                    for (Integer e2 : dp.get(i - j)) {
                        set.add(e1 + e2);
                        set.add(e1 - e2);
                        set.add(e1 * e2);
                        if (e2 != 0) {
                            set.add(e1 / e2);
                        }
                    }
                }
            }
            if (set.contains(number)) return i;
            dp.add(i, set);
        }

        return -1;
    }
}