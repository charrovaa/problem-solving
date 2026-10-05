import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {

        char[] turn = new char[t * m + 1];

        Queue<Character> queue = new LinkedList<>();
        int nextNum = 0;

        for (int i = 1; i < turn.length; i++) {
            if (queue.isEmpty()) {
                String converted = Integer.toString(nextNum, n).toUpperCase();
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
}