import java.util.ArrayDeque;

class Solution {
    public int solution(int[] order) {
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        int idx = 0;

        for (int box = 1; box <= order.length; box++) {
            stack.push(box);
            while (!stack.isEmpty() && stack.peek() == order[idx]) {
                stack.pop();
                idx++;
            }
        }

        return idx;
    }
}