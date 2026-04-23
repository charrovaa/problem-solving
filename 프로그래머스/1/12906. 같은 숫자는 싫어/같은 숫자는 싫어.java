import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] result = new int[arr.length];
        int num = 10;
        int count = 0;

        for (int i : arr) {
            if (i != num) {
                num = i;
                result[count++] = i;
            }
        }

        return Arrays.copyOf(result, count);
    }
}