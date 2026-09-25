import java.util.*;

class Solution {
    public int solution(String s) {
        char[] arr = s.toCharArray();
        int answer = 0;
        for (int start = 0; start < arr.length; start++) {
            Deque<Character> deque = new ArrayDeque<>();
            boolean balanced = true;
            for (int e = 0; e < arr.length; e++) {
                char cur = arr[(start + e) % arr.length];
                if (isOpen(cur)) deque.push(cur);
                else {
                    if (!deque.isEmpty() && matches(deque.peek(), cur)) {
                        deque.pop();
                        continue;
                    }
                    balanced = false;
                    break;
                }
            }
            if (deque.isEmpty() && balanced) answer++;
        }
        return answer;
    }

    private boolean isOpen(char c) {
        return c == '(' || c == '{' || c == '[';
    }

    private boolean matches(char c1, char c2) {
        return c1 == '(' && c2 == ')' ||
        c1 == '{' && c2 == '}' ||
        c1 == '[' && c2 == ']';
    }
}