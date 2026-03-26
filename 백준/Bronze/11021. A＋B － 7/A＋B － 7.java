import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int count = Integer.parseInt(reader.readLine());
            for (int i = 1; i <= count; i++) {
                String[] inputs = reader.readLine().split(" ");
                int sum = Integer.parseInt(inputs[0]) + Integer.parseInt(inputs[1]);
                System.out.printf("Case #%d: %d\n", i, sum);
            }
        } catch (IOException e) {

        }
    }
}