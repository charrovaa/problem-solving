import java.util.ArrayList;
import java.util.Iterator;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {

        int answer = 0;
        ArrayList<String> wants = new ArrayList<>();

        for (int i = 0; i < want.length; i++) {
            for (int j = 0; j < number[i]; j++) wants.add(want[i]);
        }

        for (int i = 0; i <= discount.length - 10; i++) {
            ArrayList<String> clone = (ArrayList<String>) wants.clone();
            for (int j = i; j < i + 10; j++) {
                Iterator<String> it = clone.iterator();
                boolean found = false;
                while (it.hasNext()) {
                    if (it.next().equals(discount[j])) {
                        found = true;
                        it.remove();
                        break;
                    }
                }
                if (!found) break;
                // if (!clone.contains(discount[j])) break;
                // clone.remove(discount[j]);
            }
            if (clone.size() == 0) answer++;
        }

        return answer;
    }
}