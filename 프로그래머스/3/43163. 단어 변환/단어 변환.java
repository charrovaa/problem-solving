import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        record Data(String word, Integer lev){}
        Queue<Data> queue = new LinkedList<>();
        queue.offer(new Data(begin, 0));

        while(!queue.isEmpty()) {
            Data curData = queue.poll();
            String curWord = curData.word;
            int curLev = curData.lev;
            if (curWord.equals(target)) return curLev;
            for (int i = 0; i < words.length; i++) {
                if (words[i] != null) {
                    boolean flag = false;
                    for (int j = 0; j < words[i].length(); j++) {
                        if (curWord.charAt(j) != words[i].charAt(j)) {
                            if (!flag) {
                                flag = true;
                            } else {
                                flag = false;
                                break;
                            }
                        }
                    }
                    if (flag) {
                        queue.offer(new Data(words[i], curLev + 1));
                        words[i] = null;
                    }
                }
            }
        }
        return 0;
    }
}