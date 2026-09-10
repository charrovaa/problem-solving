class Solution {
    public String solution(String s) {
        String[] strings = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (String string : strings) {
            int num = Integer.parseInt(string);
            if (num > max) max = num;
            if (num < min) min = num;
        }

        return "" + min + " " + max;
    }
}