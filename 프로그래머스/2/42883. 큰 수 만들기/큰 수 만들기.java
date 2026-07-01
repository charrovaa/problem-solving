import java.util.*;

class Solution {
    public String solution(String number, int k) {

        Stack<Integer> stack = new Stack<>();
        int index = 0;

        while (index < number.length()) {
            int num = number.charAt(index) - '0';
            while (!stack.isEmpty() && k > 0 && stack.peek() < num) {
                stack.pop();
                k--;
            }
            stack.push(num);
            index++;
        }

        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder answer = new StringBuilder();

        for (int i : stack) {
            answer.append(i);
        }

        return answer.toString();
    }
}