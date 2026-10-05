class Solution {
    public String solution(int n, int t, int m, int p) {

        StringBuilder target = new StringBuilder();
        StringBuilder result = new StringBuilder();
        int num = 0;

        while (target.length() < t * m) target.append(Integer.toString(num++, n).toUpperCase());
        for (int i = p - 1; result.length() < t; i += m) result.append(target.charAt(i));

        return result.toString();
    }
}