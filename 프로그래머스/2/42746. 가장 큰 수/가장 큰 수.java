import java.util.ArrayList;
import java.util.List;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        for (int i : numbers) {
            list.add(i);
        }

        list.sort((a, b) -> {
            String as = String.valueOf(a), bs = String.valueOf(b);
            return -Integer.compare(Integer.parseInt(as + bs), Integer.parseInt(bs + as));
        });

        for (Integer integer : list) {
            sb.append(integer);
        }

        if (sb.charAt(0) == '0') {
            return "0";
        }

        return sb.toString();
    }
}