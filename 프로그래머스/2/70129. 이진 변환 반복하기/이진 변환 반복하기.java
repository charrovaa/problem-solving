class Solution {
    public int[] solution(String s) {

        int zero = 0;
        int one = 0;
        int cnt = 0;

        while (s.length() > 1) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    zero++;
                } else {
                    one++;
                }
            }
            s = Integer.toBinaryString(one);
            one = 0;
            cnt++;
        }

        return new int[]{cnt, zero};
    }
}