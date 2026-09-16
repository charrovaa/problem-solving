class Solution {
    public String solution(String s) {

        String[] ss = s.split("");
        String answer = "";
        boolean isFirst = true;

        for (String string : ss) {

            char c = string.charAt(0);

            if (c == ' ') {
                isFirst = true;
            } else if (isFirst) {
                c = Character.toUpperCase(c);
                isFirst = false;
            } else {
                c = Character.toLowerCase(c);
            }

            answer += String.valueOf(c);
        }

        return answer;
    }
}