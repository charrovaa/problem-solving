class Solution {
    public int solution(int n) {
        int cnt = Integer.bitCount(n);
        while (true) {
            int newCnt = Integer.bitCount(++n);
            if (cnt == newCnt) return n;
        }
    }
}