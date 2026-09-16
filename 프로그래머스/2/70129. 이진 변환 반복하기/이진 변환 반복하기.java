class Solution {
    public int[] solution(String s) {

        int zero = 0;
        int cnt = 0;

        String temp = "";
        int size = s.length();

        while (size > 1) {
            for (int i = 0; i < size; i++) {
                if (s.charAt(i) == '0') {
                    zero++;
                } else {
                    temp += '1';
                }
            }
            s = Integer.toBinaryString(temp.length());
            size = s.length();
            temp = "";

            cnt++;
        }

        return new int[]{cnt, zero};
    }
}