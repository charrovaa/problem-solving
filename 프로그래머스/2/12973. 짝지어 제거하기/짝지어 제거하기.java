import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.size() > 0 && stack.peek() == c) stack.pop();
            else stack.push(c);
        }

        return stack.size() == 0 ? 1 : 0;
    }
}