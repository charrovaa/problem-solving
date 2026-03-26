import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int mon = scanner.nextInt() - 1;
            int day = scanner.nextInt();

            List<Integer> thirtyOne = Arrays.asList(1, 3, 5, 7, 8, 10, 12);
            List<Integer> thirty = Arrays.asList(4, 6, 9, 11);
            List<String> weeks = Arrays.asList("SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT");

            while (mon > 0) {
                if (thirtyOne.contains(mon)) {
                    day += 31;
                    mon--;
                } else if (thirty.contains(mon)) {
                    day += 30;
                    mon--;
                } else if (mon == 2) {
                    day += 28;
                    mon--;
                }
            }
            
            String week = weeks.get(day % 7);
            System.out.print(week);
        }
    }
}