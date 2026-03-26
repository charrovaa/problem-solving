import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String input;
            while ((input = reader.readLine()) != null) {
                String[] inputs = input.trim().split("\\s+");
                int a = Integer.parseInt(inputs[0]);
                int b = Integer.parseInt(inputs[1]);
                if ((a == 0) && (b == 0)) {
                    break;
                }
                System.out.println(a + b);
            }
        } catch (IOException e) {

        }
    }
}