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

        for (int i = 0; i < name.length(); i++) {
            int nextIndex = i + 1;
            while (nextIndex < name.length() && name.charAt(nextIndex) == 'A') nextIndex++;
            int right = (i * 2) + (name.length() - nextIndex);
            int left = (name.length() - nextIndex) * 2 + i;
            min = Math.min(min, Math.min(right, left));
        }
        
        return count + min;
    }
}