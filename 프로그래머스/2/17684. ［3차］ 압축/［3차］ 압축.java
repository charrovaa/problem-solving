import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(String msg) {
        List<String> dic = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        for (char c = 'A'; c <= 'Z'; c++) dic.add(String.valueOf(c));

        for (int i = 0; i < msg.length();) {
            for (int j = dic.size() - 1; j >= 0; j--) {
                if (msg.substring(i).startsWith(dic.get(j))) {
                    i += dic.get(j).length();
                    ans.add(j + 1);
                    if (i < msg.length()) dic.add(dic.get(j) + msg.charAt(i));
                    break;
                }
            }
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}