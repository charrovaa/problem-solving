import java.util.*;

class Solution {
    public int[] solution(String msg) {

        Map<String, Integer> dic = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        int preNum = 0;

        // 사전 초기화
        for (char c = 'A'; c <= 'Z'; c++) dic.put(String.valueOf(c), ++preNum);

        for (int start = 0; start < msg.length();) {
            int end = start + 1;
            // 사전에서 가장 긴 문자열 찾기 (반복문 종료 시 end = 문자열의 끝 + 1)
            while (end <= msg.length() && dic.containsKey(msg.substring(start, end))) end++;
            // 찾은 글자 반환하기
            ans.add(dic.get(msg.substring(start, end - 1)));
            // 다음 글자가 남은 경우 (긴 문자열 + 다음 글자) 사전에 등록
            if (end <= msg.length()) dic.put(msg.substring(start, end), ++preNum);

            start = end - 1;
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}