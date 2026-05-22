class Solution {
    public int solution(int[][] sizes) {

        int width = 0;
        int length = 0;

        for (int[] card : sizes) {
            width = Math.max(width, Math.max(card[0], card[1]));
            length = Math.max(length, Math.min(card[0], card[1]));
        }

        int answer = width * length;
        return answer;
    }
}