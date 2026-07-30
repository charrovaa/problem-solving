class Solution {
    public int solution(int[] money) {
        int[] includeFirst = new int[money.length];
        int[] excludeFirst = new int[money.length];

        includeFirst[0] = money[0];
        includeFirst[1] = -1; excludeFirst[1] = money[1];
        includeFirst[2] = money[0] + money[2]; excludeFirst[2] = money[2];

        int lastIndex = money.length - 1;

        for (int i = 3; i <= lastIndex; i++) {
            int includeMax = Math.max(includeFirst[i - 2], includeFirst[i - 3]);
            int excludeMax = Math.max(excludeFirst[i - 2], excludeFirst[i - 3]);

            if (includeMax == -1) {
                includeFirst[i] = -1;
            } else {
                includeFirst[i] = includeMax + money[i];
            }

            if (excludeMax == -1) {
                excludeFirst[i] = -1;
            } else {
                excludeFirst[i] = excludeMax + money[i];
            }
        }

        return Math.max(Math.max(includeFirst[lastIndex - 1], includeFirst[lastIndex - 2]), Math.max(excludeFirst[lastIndex], excludeFirst[lastIndex - 1]));
    }
}