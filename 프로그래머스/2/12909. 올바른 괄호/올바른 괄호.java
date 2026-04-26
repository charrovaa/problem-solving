class Solution {
    boolean solution(String s) {
        char[] chars = s.toCharArray();
        int left = 0; // "("
        int right = 0; // ")"

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                left++;
            } else {
                right++;
            }

            if (left < right) return false;
        }

        if (left == right) return true;

        return false;
    }
}