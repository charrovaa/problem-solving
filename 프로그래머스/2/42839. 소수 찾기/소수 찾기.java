import java.util.*;

class Solution {

    Set<Integer> answer = new HashSet<>();
    int[] arrNumbers; // 숫자 카드
    boolean[] visited; // 방문 여부

    public int solution(String numbers) {
        int size = numbers.length();
        arrNumbers = new int[size];
        visited = new boolean[size];
        for (int i = 0; i < size; i++) {
            arrNumbers[i] = numbers.charAt(i) - '0';
        }
        backTracking(0);
        return answer.size();
    }

    void backTracking(int number) {
        for (int i = 0; i < arrNumbers.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                int val = number * 10 + arrNumbers[i];
                if (isPrime(val)) answer.add(val);
                backTracking(val);
                visited[i] = false;
            }
        }
    }

    boolean isPrime(int number) {
        if (number == 0 || number == 1) return false;
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}