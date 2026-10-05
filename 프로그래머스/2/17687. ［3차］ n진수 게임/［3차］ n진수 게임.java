import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {

        char[] turn = new char[t * m + 1];

        Queue<Character> queue = new LinkedList<>();
        int nextNum = 0;

        for (int i = 1; i < turn.length; i++) {
            if (queue.isEmpty()) {
                char[] convertedNumber = convertToBase(n, nextNum);
                for (char c : convertedNumber) {
                    queue.add(c);
                }
                nextNum++;
            }
            turn[i] = queue.poll();
        }

        String answer = "";

        for (int i = p; i < turn.length; i += m) {
            answer += turn[i];
        }

        return answer;
    }

    private char[] convertToBase (int base, int num) {

        String reverseResult = "";

        while (num >= 0) {
            int intToken = num % base;
            num /= base;
            if (intToken < 10) reverseResult += intToken;
            else {
                char charToken = (char) ('A' + intToken - 10);
                reverseResult += charToken;
            }

            if (num == 0) break;
        }

        char[] result = new char[reverseResult.length()];
        int idx = 0;

        for (int i = result.length - 1; i >= 0; i--) {
            result[idx++] = reverseResult.charAt(i);
        }

        return result;
    }
}