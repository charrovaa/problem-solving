import java.util.*;

class Solution {
    public int[] solution(String s) {

        Set<Integer> set = new HashSet<>();
        String[] arr = s.replaceAll("[{}]", " ").trim().split(" , ");
        int[] ans = new int[arr.length];
        int idx = 0;

        Arrays.sort(arr, (a, b) -> a.length() - b.length());
        for (String str : arr) {
            String[] nums = str.split(",");
            for (String num : nums) {
                int e = Integer.parseInt(num);
                if (set.add(e)) ans[idx++] = e;
            }
        }

        return ans;
    }
}