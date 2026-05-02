import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> passing = new LinkedList<Integer>();

        int truckIndex = 0;
        int weightSum = 0;
        int count = 0;

        while (truckIndex != truck_weights.length || weightSum != 0) {

            if (bridge_length == passing.size()) {
                weightSum -= passing.poll();
            }

            if (truckIndex < truck_weights.length && weight >= weightSum + truck_weights[truckIndex]) {
                weightSum += truck_weights[truckIndex];
                passing.offer(truck_weights[truckIndex++]);
            } else {
                passing.offer(0);
            }
            
            count++;
        }
        
        return count;
    }
}