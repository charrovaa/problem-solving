class Solution {
    public int solution(int n) {

        /*
            항          누적 합
            a           a           i = 1
            a + 1       2a + 1      i = 2
            a + 2       3a + 3      i = 3
            a + 3       4a + 6      i = 4
            a + 4       5a + 10     i = 5

            a부터 a + i - 1까지의 등차수열 합 n = ia + i(i - 1)/2
        */

        int answer = 0;

        // i = 항의 수 (i개의 항의 수로 n을 표현할 수 있는 a가 존재하는가?)
        for (int i = 1; (i * (i - 1) / 2) < n; i++) {
            int ia = n - (i * (i - 1) / 2);
            if (ia % i == 0) answer++;
        }

        return answer;
    }
}