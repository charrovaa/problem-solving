class Solution {
    public String solution(String number, int k) {

        int[] numbers = new int[number.length()];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = number.charAt(i) - '0';
        }

        int length = number.length() - k; // 생성할 숫자의 길이
        String answer = "";
        int index = 0;
        int maxIndex = 0;

        while (length != 0) {
            for (int i = index; i <= numbers.length - length; i++) {
                maxIndex = numbers[maxIndex] < numbers[i] ? i : maxIndex;
            }
            answer += numbers[maxIndex];
            index = ++maxIndex;
            length--;
        }

        return answer;
    }
}