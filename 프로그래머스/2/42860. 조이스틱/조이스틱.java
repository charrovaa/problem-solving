class Solution {
    public int solution(String name) {

        int count = 0;

        // 알파벳 변경 비용
        for (char c : name.toCharArray()) {
            count += Math.min(c - 'A', 'Z' - c + 1);
        }

        // 커서 이동 비용
        // 각 A가 아닌 글자에서 반대 방향으로 갔을 때 값들 중 최소
        int min = name.length() - 1;

        for (int i = 0; i < name.length(); i++) { // A 연속 문자열에서의 첫 번째 A의 위치
            char c = name.charAt(i);
            if (c != 'A') continue;
            int nextIndex = i;
            while (nextIndex < name.length() && name.charAt(nextIndex) == 'A') nextIndex++; // A 연속 문자열에서의 마지막 A의 위치 + 1
            int right;
            int left;
            if (i == 0) {
                right = name.length() - nextIndex;
                left = (name.length() - nextIndex) * 2;
            } else {
                right = (i - 1) * 2 + (name.length() - nextIndex);
                left = (name.length() - nextIndex) * 2 + (i - 1);
            }
            min = Math.min(min, Math.min(right, left));
        }
        return count + min;
    }
}