import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> list = new LinkedList<Integer>();
        int num = arr[0];
        list.add(num);

        for (int i : arr) {
            if (i != num) {
                num = i;
                list.add(i);
            }
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}