class Solution {
    public String solution(String s) {

        String answer = "";
        String[] ss = s.toLowerCase().split("");
        boolean isFirst = true;

        for (String string : ss) {
            answer += isFirst ? string.toUpperCase() : string;
            isFirst = string.equals(" ");
        }

        return answer;
    }
}