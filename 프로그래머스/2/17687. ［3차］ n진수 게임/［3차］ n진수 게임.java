import java.util.*;

class Solution {
    private static final String DIGITS = "0123456789ABCDEF";
    public String solution(int n, int t, int m, int p) {

        char[] turn = new char[t * m + 1];

        Queue<Character> queue = new LinkedList<>();
        int nextNum = 0;

        for (int i = 1; i < turn.length; i++) {
            if (queue.isEmpty()) {
                String converted = convertToBase(n, nextNum);
                for (char c : converted.toCharArray()) queue.add(c);
                nextNum++;
            }
            turn[i] = queue.poll();
        }

        StringBuilder answer = new StringBuilder();

        for (int i = p; i < turn.length; i += m) {
            answer.append(turn[i]);
        }

        return answer.toString();
    }

    private String convertToBase (int base, int num) {

        StringBuilder result = new StringBuilder();

        do {
            int token = num % base;
            result.append(DIGITS.charAt(token));
            num /= base;
        } while (num > 0);

        return result.reverse().toString();
    }
}