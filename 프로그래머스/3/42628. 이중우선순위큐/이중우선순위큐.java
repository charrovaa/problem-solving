import java.util.*;

class Solution {
    public int[] solution(String[] operations) {

        NavigableSet<Integer> nums = new TreeSet<Integer>();

        for (String operation : operations) {
            if (operation.startsWith("I")) {
                // 숫자 삽입
                nums.add(Integer.parseInt(operation.substring(2)));
            } else {
                if (nums.isEmpty()) continue;
                if (operation.startsWith("D 1")) {
                    // 최댓값 삭제
                    nums.remove(nums.last());
                } else {
                    // 최솟값 삭제
                    nums.remove(nums.first());
                }
            }
        }

        int[] answer = new int[2];
        if (nums.isEmpty()) return answer;
        
        answer[0] = nums.last();
        answer[1] = nums.first();
        return answer;
    }
}