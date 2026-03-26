import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            int count = Integer.parseInt(reader.readLine());
            String[] inputs = reader.readLine().split("");
            int sum = 0;
            for (int i = 0; i < count; i++) {
                sum += Integer.parseInt(inputs[i]);
            }
            System.out.println(sum);
        } catch (IOException e) {

        }
    }
}