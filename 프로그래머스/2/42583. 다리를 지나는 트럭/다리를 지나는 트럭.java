import java.util.*;

class Solution {

    class Truck {
        int weight;
        int move;

        public Truck (int weight) {
            this.weight = weight;
            this.move = 1;
        }

        void moving() {
            move++;
        }
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {

        Queue<Truck> waitQ = new ArrayDeque<>();
        Queue<Truck> moveQ = new ArrayDeque<>();

        int answer = 0;
        int curweight = 0;

        for (int i : truck_weights) {
            Truck truck = new Truck(i);
            waitQ.offer(truck);
        }

        while (!waitQ.isEmpty() || !moveQ.isEmpty()) {

            answer++;

            if (moveQ.isEmpty()) {
                Truck truck = waitQ.poll();
                curweight += truck.weight;
                moveQ.offer(truck);
                continue;
            }

            for (Truck truck : moveQ) {
                truck.moving();
            }

            if (moveQ.peek().move > bridge_length) {
                Truck truck = moveQ.poll();
                curweight -= truck.weight;
            }

            if (!waitQ.isEmpty() && waitQ.peek().weight + curweight <= weight) {
                Truck truck = waitQ.poll();
                curweight += truck.weight;
                moveQ.offer(truck);
            }
        }

        return answer;
    }
}