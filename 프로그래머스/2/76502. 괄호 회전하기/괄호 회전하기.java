import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            Stack<Character> stack = new Stack<>();
            stack.push(s.charAt(0));
            for (int j = 1; j < s.length(); j++) {
                char pre = stack.isEmpty() ? ' ' : stack.peek();
                char cur = s.charAt(j);
                if (pre == '(' && cur == ')' ||
                    pre == '{' && cur == '}' ||
                    pre == '[' && cur == ']'
                ) stack.pop();
                else stack.push(cur);
            }
            if (stack.isEmpty()) answer++;
            s = rotate(s);
        }
        return answer;
    }

    private String rotate(String s) {
        return s.substring(s.length() - 1) + s.substring(0, s.length() - 1);
    }
}