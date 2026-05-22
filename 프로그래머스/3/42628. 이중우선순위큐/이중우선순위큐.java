import java.util.*;

class Solution {
    public int[] solution(String[] operations) {

        NavigableMap<Integer, Integer> nums = new TreeMap<Integer, Integer>();

        for (String operation : operations) {
            if (operation.startsWith("I")) {
                // 숫자 삽입
                int num = Integer.parseInt(operation.substring(2));
                nums.put(num, nums.getOrDefault(num, 0) + 1);
            } else {
                if (nums.isEmpty()) continue;
                int key;
                if (operation.startsWith("D 1")) {
                    // 최댓값 삭제
                    key = nums.lastKey();
                } else {
                    // 최솟값 삭제
                    key = nums.firstKey();
                }
                if (nums.get(key) == 1) {
                    nums.remove(key);
                } else {
                    nums.put(key, nums.get(key) - 1);
                }
            }
        }

        int[] answer = new int[2];
        if (!nums.isEmpty()) {
            answer[0] = nums.lastKey();
            answer[1] = nums.firstKey();
        }

        return answer;
    }
}