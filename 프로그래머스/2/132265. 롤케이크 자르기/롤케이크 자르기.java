class Solution {
    public int solution(int[] topping) {
        int[] rightCounts = new int[10001];
        boolean[] inLeft = new boolean[10001];
        int rightKinds = 0;
        int leftKinds = 0;
        int answer = 0;

        for (int t : topping) {
            if (rightCounts[t]++ == 0) rightKinds++;
        }

        for (int i = 0; i < topping.length - 1; i++) {
            int t = topping[i];
            if (!inLeft[t]) {
                inLeft[t] = true;
                leftKinds++;
            }
            if (--rightCounts[t] == 0) rightKinds--;
            if (rightKinds == leftKinds) answer++;
        }
        return answer;
    }
}