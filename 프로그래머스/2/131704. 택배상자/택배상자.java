import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<Integer>();
        int index = 0;
        int ans = 0;

        for (int i = 1; i <= order.length;) { // 메인 컨테이너 벨트
            if (order[index] == i) { // 메인 -> 트럭
                ans++;
                i++;
                index++;
            } else if (!stack.isEmpty() && order[index] == stack.peek()) { // 보조 -> 트럭
                stack.pop();
                ans++;
                index++;
            } else { // 메인 -> 보조
                stack.push(i);
                i++;
            }
        }

        while (!stack.isEmpty() && stack.pop() == order[index]) {
            ans++;
            index++;
        }

        return ans;
    }
}