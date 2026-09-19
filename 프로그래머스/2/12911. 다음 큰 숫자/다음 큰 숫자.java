class Solution {
    public int solution(int n) {
        // Gosper's hack
        int lowestBit = n & -n;
        int remaining = (((n + lowestBit) ^ n) / lowestBit) >> 2;
        return n + lowestBit | remaining;
    }
}