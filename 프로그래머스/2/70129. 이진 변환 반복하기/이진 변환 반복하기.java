class Solution {
    public int[] solution(String s) {

        int[] answer = new int[2]; // 변환, 0

        while (s.length() > 1) {
            answer[0]++;
            answer[1] += s.length();
            s = s.replace("0", "");
            answer[1] -= s.length();
            s = Integer.toBinaryString(s.length());
        }

        return answer;
    }
}