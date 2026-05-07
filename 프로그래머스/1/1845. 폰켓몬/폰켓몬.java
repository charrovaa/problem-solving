import java.util.*;

class Solution {
    public int solution(int[] nums) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // 몬스터 번호, 몬스터 수

        for (int i : nums) {
            if (map.containsKey(i)) {
                int val = map.get(i);
                map.put(i, ++val);
            } else {
                map.put(i, 1);
            }
        }

        if (map.size() > nums.length / 2) return nums.length / 2;

        return map.size();
    }
}