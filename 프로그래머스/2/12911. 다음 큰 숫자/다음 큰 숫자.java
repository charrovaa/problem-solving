class Solution {
    public int solution(int n) {

        String input = Integer.toBinaryString(n);
        int cnt = 0;

        for (char c : input.toCharArray()) if (c == '1') cnt++;

        while (true) {
            int newCnt = 0;

            n += 1;
            input = Integer.toBinaryString(n);

            for (char c : input.toCharArray()) if (c == '1') newCnt++;

            if (cnt == newCnt) return n;

        }
    }
}