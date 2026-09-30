import java.util.*;

class Solution {
    public int[] solution(String s) {

        List<List<Integer>> sets = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        boolean[] used = new boolean[100_000];

        for (int i = 1; i < s.length() - 1; i++) {
            int begin = i;
            while (s.charAt(i++) != '}');
            sets.add(parsing(s.substring(begin, i)));
        }

        sets.sort((a, b) -> a.size() - b.size());

        for (int i = 0; i < sets.size(); i++) {
            List<Integer> set = sets.get(i);
            for (int e : set) {
                if (!used[e]) {
                    ans.add(e);
                    used[e] = true;
                }
            }
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    private List<Integer> parsing(String s) {
        List<Integer> set = new ArrayList<>();
        for (int i = 1; i < s.length() - 1; i++) {
            int begin = i;
            while (s.charAt(i) != ',' && s.charAt(i) != '}') i++;
            set.add(Integer.parseInt(s.substring(begin, i)));
        }
        return set;
    }
}