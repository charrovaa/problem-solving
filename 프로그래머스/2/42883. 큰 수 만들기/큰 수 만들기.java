import java.util.*;

class Solution {
    public String solution(String number, int k) {

        Stack<Integer> stack = new Stack<>();
        int length = number.length() - k;
        int index = 0;

        while (index < number.length()) {
            int num = number.charAt(index) - '0';
            if (stack.isEmpty()) {
                stack.push(num);
                index++;
                length--;
            } else if (stack.peek() < num && number.length() - index > length) {
                stack.pop();
                length++;
            } else if (length > 0) {
                stack.push(num);
                index++;
                length--;
            } else {
                index++;
            }
        }

        StringBuilder answer = new StringBuilder();

        for (int i : stack) {
            answer.append(i);
        }

        return answer.toString();
    }
}