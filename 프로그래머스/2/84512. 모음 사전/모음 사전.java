class Solution {
    public int solution(String word) {
        int answer = 0;
        int per = 5 + (5 * 5) + (5 * 5 * 5) + (5 * 5 * 5 * 5) + (5 * 5 * 5 * 5* 5); // 전체 단어의 수
        for (String s : word.split("")) answer += "AEIOU".indexOf(s) * (per /= 5) + 1;
        return answer;
    }
}